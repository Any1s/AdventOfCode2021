package de.mbdevelopment.adventofcode.year2021.solvers.day8

import de.mbdevelopment.adventofcode.year2021.solvers.PuzzleSolver

class Day8Puzzle1 : PuzzleSolver {

    companion object {
        private val uniqueNumbersOfSegments = setOf(
            2, // Digit 1
            3, // Digit 7
            4, // Digit 4
            7 // Digit 8
        )
    }

    override fun solve(inputLines: Sequence<String>) = countDigitsWithUniqueNumberOfSegments(inputLines).toString()

    private fun countDigitsWithUniqueNumberOfSegments(digitSignalsAndReading: Sequence<String>) = digitSignalsAndReading
        .filter { it.isNotBlank() }
        .mapNotNull { it.split(" | ").lastOrNull() }
        .map { it.trim().split(' ') }
        .map { it.map { activeSegments -> activeSegments.length in uniqueNumbersOfSegments } }
        .flatMap { it }
        .count { it }

}