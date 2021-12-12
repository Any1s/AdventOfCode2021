package de.mbdevelopment.adventofcode.year2021.solvers.day12

sealed class Cave {
    data class BigCave(val name: String) : Cave()
    data class SmallCave(val name: String) : Cave()
}
