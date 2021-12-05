package de.mbdevelopment.adventofcode.year2021.solvers.day5

import de.mbdevelopment.adventofcode.year2021.solvers.PuzzleSolver

abstract class Day5Puzzle : PuzzleSolver {

    companion object {
        private val INPUT_PATTERN = "(\\d+),(\\d+) -> (\\d+),(\\d+)".toPattern()
    }

    abstract fun solve(lines: List<Line>, map: List<IntArray>): Int

    final override fun solve(inputLines: Sequence<String>): String {
        val lines = inputLines.toLines()
        val map = emptyMapOf(lines)
        return solve(lines, map).toString()
    }

    private fun Sequence<String>.toLines() = filter { it.isNotBlank() }
        .map { it.toLine() }
        .toList()

    private fun String.toLine() = INPUT_PATTERN.matcher(this).let {
        if (!it.matches()) throw IllegalArgumentException("'$this' cannot be converted to line")
        val from = Point(it.group(1).toInt(), it.group(2).toInt())
        val to = Point(it.group(3).toInt(), it.group(4).toInt())
        Line(from, to)
    }

    private fun emptyMapOf(lines: List<Line>): List<IntArray> {
        val furthestPoint = lines.fold(Point(0, 0)) { a, b ->
            val maxX = listOf(a.x, b.from.x, b.to.x).maxOrNull() ?: 0
            val maxY = listOf(a.y, b.from.y, b.to.y).maxOrNull() ?: 0
            Point(maxX, maxY)
        }
        return List(furthestPoint.x + 1) { IntArray(furthestPoint.y + 1) { 0 } }
    }
}

data class Point(val x: Int, val y: Int)

data class Line(val from: Point, val to: Point) {

    fun points(): List<Point> {
        val rangeX = (if (from.x <= to.x) from.x..to.x else from.x.downTo(to.x)).toList()
        val rangeY = (if (from.y <= to.y) from.y..to.y else from.y.downTo(to.y)).toList()
        return if (rangeX.size > 1 && rangeY.size > 1) {
            rangeX.mapIndexed { index, x -> Point(x, rangeY[index]) }
        } else if (rangeX.size > 1) {
            rangeX.map { Point(it, from.y) }
        } else if (rangeY.size > 1) {
            rangeY.map { Point(from.x, it) }
        } else {
            emptyList()
        }
    }
}