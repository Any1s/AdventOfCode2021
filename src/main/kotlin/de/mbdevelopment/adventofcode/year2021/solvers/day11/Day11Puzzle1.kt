package de.mbdevelopment.adventofcode.year2021.solvers.day11

class Day11Puzzle1 : Day11Puzzle() {
    override fun simulate(octopusGrid: List<MutableList<Int>>) =
        (0..99).map { step(octopusGrid) }.reduce(Int::plus)

}
