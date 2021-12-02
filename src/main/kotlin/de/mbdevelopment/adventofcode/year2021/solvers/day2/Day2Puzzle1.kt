package de.mbdevelopment.adventofcode.year2021.solvers.day2

import de.mbdevelopment.adventofcode.year2021.solvers.PuzzleSolver

class Day2Puzzle1: PuzzleSolver {

    override fun solve(inputLines: Sequence<String>) = productOfSumOfDirections(inputLines).toString();

    private fun productOfSumOfDirections(directions: Sequence<String>) = directions
        .map { it.split(" ") }
        .map { toShift(it[0], it[1].toInt()) }
        .reduce { a, b -> a.first + b.first to a.second + b.second }
        .toList()
        .reduce { a, b -> a * b }

    private fun toShift(direction: String, step: Int) = when(direction) {
        "forward" -> step to 0
        "down" -> 0 to step
        "up" -> 0 to -1 * step
        else -> 0 to 0
    }
}