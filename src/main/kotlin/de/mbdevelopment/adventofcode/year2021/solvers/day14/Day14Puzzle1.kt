package de.mbdevelopment.adventofcode.year2021.solvers.day14

import de.mbdevelopment.adventofcode.year2021.solvers.PuzzleSolver

class Day14Puzzle1 : PuzzleSolver {

    override fun solve(inputLines: Sequence<String>) = highestMinusLowestQuantity(inputLines.toList()).toString()

    private fun highestMinusLowestQuantity(polymerInstructions: List<String>): Int {
        val polymerTemplate = polymerInstructions.first()
        val pairInsertionRules = polymerInstructions
            .asSequence()
            .drop(1)
            .filter { it.isNotBlank() }
            .map { it.split(" -> ") }
            .map { it[0] to it[1] }
            .map { (it.first[0] to it.first[1]) to it.second[0] }
            .toMap()

        val polymer = (0..9)
            .fold(polymerTemplate) { previous: String, _: Int -> insertAll(previous, pairInsertionRules) }

        val elementCounts = polymer.groupingBy { it }.eachCount()

        return elementCounts.values.sorted().let { it.last() - it.first() }
    }

    private fun insertAll(polymer: String, pairInsertionRules: Map<Pair<Char, Char>, Char>): String {
        val newPolymer = StringBuilder()
        polymer.windowed(2).forEach {
            newPolymer.append(it[0])
            pairInsertionRules[it[0] to it[1]]?.let { newElement -> newPolymer.append(newElement) }
        }
        newPolymer.append(polymer.last())

        return newPolymer.toString()
    }

}