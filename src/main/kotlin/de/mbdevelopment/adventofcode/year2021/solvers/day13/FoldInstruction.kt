package de.mbdevelopment.adventofcode.year2021.solvers.day13

sealed class FoldInstruction {
    data class Up(val alongY: Int) : FoldInstruction()
    data class Left(val alongX: Int) : FoldInstruction()
}