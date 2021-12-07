package de.mbdevelopment.adventofcode.year2021.solvers.day7

import de.mbdevelopment.adventofcode.year2021.solvers.PuzzleSolver
import kotlin.math.ceil
import kotlin.math.floor
import kotlin.math.roundToLong

abstract class Day7Puzzle(private val costFunction: (target: Int, position: Int) -> Double) : PuzzleSolver {

    final override fun solve(inputLines: Sequence<String>): String {
        val sortedCrabPositions = sortedCrabPositions(inputLines)
        val alignmentPoints = alignmentPoints(sortedCrabPositions).let {
            if (it - floor(it) != 0.0) listOf(ceil(it), floor(it)).map(Double::toInt)
            else listOf(it.toInt())
        }
        val cost = alignmentPoints.minOfOrNull { alignmentPoint ->
            sortedCrabPositions.sumOf { costFunction(alignmentPoint, it) }
        } ?: 0.0

        return cost.roundToLong().toString()
    }

    abstract fun alignmentPoints(sortedCrabPositions: List<Int>): Double

    private fun sortedCrabPositions(crabPositions: Sequence<String>) =
        crabPositions.filter { it.isNotBlank() }.single().split(',').map { it.toInt() }.sorted()

}