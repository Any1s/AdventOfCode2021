package de.mbdevelopment.adventofcode.year2021.solvers.day18

class Day18Puzzle1 : Day18Puzzle() {

    override fun homework(snailfishNumbers: Sequence<String>) = snailfishNumbers
        .filter { it.isNotBlank() }
        .map { it.toList() }
        .map { ArrayDeque(it) }
        .map { parse(it) }
        .reduce { sum, next -> sum + next }
        .magnitude()

}
