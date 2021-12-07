package de.mbdevelopment.adventofcode.year2021.solvers.day7

import kotlin.math.abs

class Day7Puzzle1 : Day7Puzzle(this::linearCost) {

    companion object {
        private fun linearCost(target: Int, position: Int) = abs(target - position).toDouble()
    }

    // Median
    override fun alignmentPoints(sortedCrabPositions: List<Int>) =
        if (sortedCrabPositions.size % 2 == 1) {
            sortedCrabPositions[(sortedCrabPositions.size - 1) / 2 - 1].toDouble()
        } else {
            val medianSum =
                (sortedCrabPositions[sortedCrabPositions.size / 2 - 1] + sortedCrabPositions[sortedCrabPositions.size / 2])
            (medianSum.toDouble() / 2.0)
        }

}