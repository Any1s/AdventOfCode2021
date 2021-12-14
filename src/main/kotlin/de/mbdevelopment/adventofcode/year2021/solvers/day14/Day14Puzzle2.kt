package de.mbdevelopment.adventofcode.year2021.solvers.day14

import de.mbdevelopment.adventofcode.year2021.solvers.PuzzleSolver

class Day14Puzzle2 : PuzzleSolver {

    override fun solve(inputLines: Sequence<String>) = highestMinusLowestQuantity(inputLines.toList()).toString()

    private fun highestMinusLowestQuantity(polymerInstructions: List<String>): Long {
        val polymerTemplate = polymerInstructions.first()
        val pairInsertionRules = polymerInstructions
            .asSequence()
            .drop(1)
            .filter { it.isNotBlank() }
            .map { it.split(" -> ") }
            .map { it[0] to it[1] }
            .toMap()

        var pairCounts = polymerTemplate
            .windowed(2)
            .groupingBy { it }
            .fold(0L) { accumulator: Long, _: String -> accumulator + 1 }
        val elementCounts = polymerTemplate
            .groupingBy { it }
            .fold(0L) { accumulator, _ -> accumulator + 1 }
            .toMutableMap()

        repeat(40) {
            val roundPairCounts = mutableMapOf<String, Long>()
            pairCounts.keys.forEach {
                val newElement = pairInsertionRules[it]
                if (newElement != null) {
                    roundPairCounts.merge(it[0] + newElement, pairCounts[it]!!, Long::plus)
                    roundPairCounts.merge(newElement + it[1], pairCounts[it]!!, Long::plus)
                    elementCounts.merge(newElement[0], pairCounts[it]!!, Long::plus)
                }
            }
            pairCounts = roundPairCounts
        }

        return elementCounts.values.sorted().let { it.last() - it.first() }
    }

}
