package de.mbdevelopment.adventofcode.year2021.solvers.day1

import de.mbdevelopment.adventofcode.year2021.solvers.PuzzleSolver

class Day1Puzzle1: PuzzleSolver {

    override fun solve(inputLines: Sequence<String>) = numberOfTimesADepthMeasurementIncreases(inputLines).toString();

    private fun numberOfTimesADepthMeasurementIncreases(depthMeasurements: Sequence<String>) = depthMeasurements
        .map { it.toInt() }
        .zipWithNext { a, b -> b > a }
        .count { it }
}