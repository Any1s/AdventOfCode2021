package de.mbdevelopment.adventofcode.year2021.solvers.day11

class Day11Puzzle2 : Day11Puzzle() {
    override fun simulate(octopusGrid: List<MutableList<Int>>): Int {
        val octopusCount = octopusGrid.size * octopusGrid[0].size
        var stepsSimulated = 0

        do {
            stepsSimulated += 1
        } while (step(octopusGrid) != octopusCount)

        return stepsSimulated
    }

}
