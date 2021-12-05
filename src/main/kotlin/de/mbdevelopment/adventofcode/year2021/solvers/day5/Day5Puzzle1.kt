package de.mbdevelopment.adventofcode.year2021.solvers.day5

class Day5Puzzle1 : Day5Puzzle() {

    override fun solve(lines: List<Line>, map: List<IntArray>): Int {

        lines.filter { it.from.x == it.to.x || it.from.y == it.to.y }
            .flatMap { it.points() }
            .forEach { map[it.x][it.y] = map[it.x][it.y] + 1 }

        return map.map { it.count { numberOfLines -> numberOfLines > 1 } }.reduce(Int::plus)
    }

}
