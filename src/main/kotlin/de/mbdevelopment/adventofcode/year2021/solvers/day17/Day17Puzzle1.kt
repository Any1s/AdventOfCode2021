package de.mbdevelopment.adventofcode.year2021.solvers.day17

import de.mbdevelopment.adventofcode.year2021.solvers.PuzzleSolver
import kotlin.math.max

class Day17Puzzle1 : PuzzleSolver {

    override fun solve(inputLines: Sequence<String>) = bruteForceHighestYPosition(inputLines.first()).toString()

    private fun bruteForceHighestYPosition(targetArea: String): Int {
        val targetAreaCoordinates = targetArea.removePrefix("target area: ").split(", ")
        val xTarget = targetAreaCoordinates[0].removePrefix("x=").toTargetRange()
        val yTarget = targetAreaCoordinates[1].removePrefix("y=").toTargetRange()

        var maxY = Int.MIN_VALUE
        for (startVelocityX in -1000..1000) {
            for (startVelocityY in -1000..1000) {
                var xPosition = 0
                var yPosition = 0
                var maxYForThisStartVelocities = 0 // We start at 0
                for (step in 0..1000) {
                    xPosition += max(0, startVelocityX - step)
                    yPosition += startVelocityY - step
                    if (yPosition > maxYForThisStartVelocities)
                        maxYForThisStartVelocities = yPosition

                    if (xPosition in xTarget && yPosition in yTarget && maxYForThisStartVelocities > maxY) {
                        maxY = maxYForThisStartVelocities
                    }

                    if (xPosition > xTarget.last || yPosition < yTarget.first)
                        break // beyond target, cannot hit it anymore
                }
            }
        }

        return maxY
    }

    private fun String.toTargetRange() = split("..").map { it.toInt() }.let { it[0]..it[1] }

}
