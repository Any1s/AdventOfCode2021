package de.mbdevelopment.adventofcode.year2021.solvers.day18

import de.mbdevelopment.adventofcode.year2021.solvers.PuzzleSolver
import kotlin.math.ceil
import kotlin.math.floor

abstract class Day18Puzzle : PuzzleSolver {

    final override fun solve(inputLines: Sequence<String>) = homework(inputLines).toString()

    abstract fun homework(snailfishNumbers: Sequence<String>): Long

    protected fun parse(snailfishNumber: ArrayDeque<Char>): SnailfishNumber {
        return if (snailfishNumber.first() == '[') {
            snailfishNumber.removeFirst()
            snailfishNumber.removeLast()

            val left = ArrayDeque<Char>()
            var level = 0
            while (true) {
                val next = snailfishNumber.removeFirst()
                if (next == '[') level += 1 else if (next == ']') level -= 1
                if (next == ',' && level == 0) {
                    break
                }
                left.addLast(next)
            }

            SnailfishNumber.Pair(parse(left), parse(snailfishNumber))
        } else {
            SnailfishNumber.Regular(snailfishNumber.joinToString("").toLong())
        }
    }

    protected operator fun SnailfishNumber.plus(other: SnailfishNumber): SnailfishNumber {
        val sum = SnailfishNumber.Pair(this, other).also { println("after addition: $it") }
        do {
            val exploded = explode(sum).also { if (it) println("after explode: $sum") }
            val split = if (exploded) false else split(sum).also { if (it) println("after split: $sum") }
        } while (exploded || split)
        return sum
    }

    private fun explode(number: SnailfishNumber): Boolean {
        val pairSearchList = flattenForExplode(number)
        var pairReferenceToExplode: SnailfishNumberReference? = null
        for (reference in pairSearchList) {
            if (reference.number is SnailfishNumber.Pair && reference.depth == 4 && pairReferenceToExplode == null) {
                pairReferenceToExplode = reference
            }
        }

        return if (pairReferenceToExplode != null) {
            val pair = pairReferenceToExplode.number as SnailfishNumber.Pair

            val regularSearchList = flattenForSplit(number)
            val leftPos = regularSearchList.indexOfFirst { it.number == pair.left }
            val regularNumberToLeft = regularSearchList.getOrNull(leftPos - 1)?.number as? SnailfishNumber.Regular
            val regularNumberToRight = regularSearchList.getOrNull(leftPos + 2)?.number as? SnailfishNumber.Regular

            regularNumberToLeft?.let { it.value += (pair.left as SnailfishNumber.Regular).value }
            regularNumberToRight?.let { it.value += (pair.right as SnailfishNumber.Regular).value }
            (pairReferenceToExplode.parent as? SnailfishNumber.Pair)?.let {
                if (it.left == pair) it.left = SnailfishNumber.Regular(0L)
                else it.right = SnailfishNumber.Regular(0L)
            }
            true
        } else false
    }

    private fun split(number: SnailfishNumber): Boolean {
        val numberToSplit = flattenForSplit(number)
            .firstOrNull { it.number is SnailfishNumber.Regular && it.number.value >= 10 }

        return if (numberToSplit != null) {
            val oldValue = (numberToSplit.number as SnailfishNumber.Regular).value
            numberToSplit.parent?.let {
                val parent = (it as SnailfishNumber.Pair)
                val newPair = SnailfishNumber.Pair(
                    SnailfishNumber.Regular(floor(oldValue / 2.0).toLong()),
                    SnailfishNumber.Regular(ceil(oldValue / 2.0).toLong())
                )
                if (parent.left == numberToSplit.number) parent.left = newPair
                else parent.right = newPair
            }
            true
        } else false
    }

    private fun flattenForExplode(
        number: SnailfishNumber,
        depth: Int = 0,
        parent: SnailfishNumber? = null
    ): List<SnailfishNumberReference> {
        return when (number) {
            is SnailfishNumber.Regular -> listOf(SnailfishNumberReference(number, depth, parent))
            is SnailfishNumber.Pair -> {
                if (number.left is SnailfishNumber.Regular && number.right is SnailfishNumber.Regular) {
                    listOf(SnailfishNumberReference(number, depth, parent))
                } else {
                    flattenForExplode(number.left, depth + 1, number) + flattenForExplode(
                        number.right,
                        depth + 1,
                        number
                    )
                }
            }
        }
    }

    private fun flattenForSplit(
        number: SnailfishNumber,
        depth: Int = 0,
        parent: SnailfishNumber? = null
    ): List<SnailfishNumberReference> {
        return when (number) {
            is SnailfishNumber.Regular -> listOf(SnailfishNumberReference(number, depth, parent))
            is SnailfishNumber.Pair -> {
                flattenForSplit(number.left, depth + 1, number) + flattenForSplit(number.right, depth + 1, number)
            }
        }
    }

}
