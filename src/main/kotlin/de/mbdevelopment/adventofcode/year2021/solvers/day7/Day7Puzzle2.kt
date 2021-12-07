package de.mbdevelopment.adventofcode.year2021.solvers.day7

import kotlin.math.abs

class Day7Puzzle2 : Day7Puzzle(this::linearlyIncreasingCost) {

    companion object {
        private fun linearlyIncreasingCost(target: Int, position: Int) = abs(target - position).let { steps ->
            (steps * (steps + 1)).toDouble() / 2.0
        }
    }

    // Average
    override fun alignmentPoints(sortedCrabPositions: List<Int>) = sortedCrabPositions.average()

}