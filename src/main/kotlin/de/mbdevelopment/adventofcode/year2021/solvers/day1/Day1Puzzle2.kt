package de.mbdevelopment.adventofcode.year2021.solvers.day1

import de.mbdevelopment.adventofcode.year2021.solvers.PuzzleSolver

class Day1Puzzle2: PuzzleSolver {

    override fun solve(inputLines: Sequence<String>) = depthMeasurementIncreasesInSlidingWindow(inputLines).toString();

    private fun depthMeasurementIncreasesInSlidingWindow(depthMeasurements: Sequence<String>) = depthMeasurements
        .map { it.toInt() }
        .windowed(3, 1, false) { it.sum() }
        .zipWithNext { a, b -> b > a }
        .count { it }
}