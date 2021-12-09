package de.mbdevelopment.adventofcode.year2021.solvers.day9

import de.mbdevelopment.adventofcode.year2021.solvers.PuzzleSolver

class Day9Puzzle1 : PuzzleSolver {

    override fun solve(inputLines: Sequence<String>) = lowPointRiskLevelSum(inputLines).toString()

    private fun lowPointRiskLevelSum(rawHeightMap: Sequence<String>): Int {
        val heightMap = rawHeightMap
            .filter { it.isNotBlank() }
            .map { line -> line.map { it.digitToInt() } }
            .toList()

        val riskLevels = (heightMap.first().indices).map { x ->
            (heightMap.indices).map { y ->
                val adjacentHeights = listOfNotNull(
                    heightMap[y].getOrNull(x - 1), // value to the left
                    heightMap[y].getOrNull(x + 1), // value to the right
                    heightMap.getOrNull(y - 1)?.get(x), // value above
                    heightMap.getOrNull(y + 1)?.get(x), // value below
                )

                val currentHeight = heightMap[y][x]
                if (adjacentHeights.all { currentHeight < it }) 1 + currentHeight
                else 0
            }
        }

        return riskLevels.map { it.reduce(Int::plus) }.reduce(Int::plus)
    }

}