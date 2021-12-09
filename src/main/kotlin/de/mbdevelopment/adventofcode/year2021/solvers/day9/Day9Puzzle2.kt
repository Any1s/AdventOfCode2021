package de.mbdevelopment.adventofcode.year2021.solvers.day9

import de.mbdevelopment.adventofcode.year2021.solvers.PuzzleSolver

class Day9Puzzle2 : PuzzleSolver {

    override fun solve(inputLines: Sequence<String>) = sizeSumOfThreeLargestBasins(inputLines).toString()

    private fun sizeSumOfThreeLargestBasins(rawHeightMap: Sequence<String>): Int {
        val heightMap = rawHeightMap
            .filter { it.isNotBlank() }
            .map { line -> line.map { it.digitToInt() } }
            .toList()

        val lowPointStarts = (heightMap.first().indices).map { x ->
            (heightMap.indices).map { y ->
                val adjacentHeights = listOfNotNull(
                    heightMap[y].getOrNull(x - 1), // value to the left
                    heightMap[y].getOrNull(x + 1), // value to the right
                    heightMap.getOrNull(y - 1)?.get(x), // value above
                    heightMap.getOrNull(y + 1)?.get(x), // value below
                )

                val currentHeight = heightMap[y][x]
                if (adjacentHeights.all { currentHeight < it }) Point(x, y)
                else null
            }
        }.flatMap { it.filterNotNull() }
            .toMutableSet()

        val basinSizes = mutableListOf<Int>()
        while (lowPointStarts.isNotEmpty()) {
            val basin = scoutBasin(heightMap, lowPointStarts.first())
            basinSizes += basin.size
            lowPointStarts -= lowPointStarts.filter { it in basin }.toSet() // Probably faster than '-= basin'
        }

        return basinSizes.sorted().takeLast(3).reduce(Int::times)
    }

    private fun scoutBasin(
        heightMap: List<List<Int>>,
        currentPoint: Point,
        knownBasinPart: MutableSet<Point> = mutableSetOf(),
        border: MutableSet<Point> = mutableSetOf()
    ): Set<Point> {
        return if (heightMap[currentPoint.y][currentPoint.x] == 9) {
            // Basin border reached
            border += currentPoint
            emptySet()
        } else {
            knownBasinPart += currentPoint

            val left = currentPoint.copy(x = currentPoint.x - 1)
            val right = currentPoint.copy(x = currentPoint.x + 1)
            val above = currentPoint.copy(y = currentPoint.y + 1)
            val below = currentPoint.copy(y = currentPoint.y - 1)

            sequenceOf(left, right, above, below)
                .filter { it.x >= 0 && it.x < heightMap.first().size && it.y >= 0 && it.y < heightMap.size }
                .filter { it !in border }
                .filter { it !in knownBasinPart }
                .map { scoutBasin(heightMap, it, knownBasinPart, border) }
                .fold(emptySet(), Set<Point>::union)
                .plus(currentPoint)
        }
    }

    data class Point(val x: Int, val y: Int)

}