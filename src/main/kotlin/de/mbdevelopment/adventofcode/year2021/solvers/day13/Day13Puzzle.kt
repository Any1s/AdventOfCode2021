package de.mbdevelopment.adventofcode.year2021.solvers.day13

import de.mbdevelopment.adventofcode.year2021.solvers.PuzzleSolver

abstract class Day13Puzzle : PuzzleSolver {

    final override fun solve(inputLines: Sequence<String>): String {
        val manualSections = inputLines.partition { !it.startsWith("fold") }

        val manual = manualSections.first
            .asSequence()
            .filter { it.isNotBlank() }
            .map { it.split(',') }
            .map { it.map(String::toInt) }
            .map { Dot(it[0], it[1]) }
            .toSet()

        val foldInstructions = manualSections.second
            .asSequence()
            .filter { it.isNotBlank() }
            .map { it.split(' ') }
            .map { it.last() }
            .map { it.split('=') }
            .mapNotNull {
                if (it[0] == "y") FoldInstruction.Up(it[1].toInt())
                else if (it[0] == "x") FoldInstruction.Left(it[1].toInt())
                else null
            }
            .toList()

        return solve(manual, foldInstructions)
    }

    abstract fun solve(manual: Set<Dot>, foldInstructions: List<FoldInstruction>): String

    protected fun Set<Dot>.fold(instruction: FoldInstruction): Set<Dot> {
        return when (instruction) {
            is FoldInstruction.Up -> fold(instruction)
            is FoldInstruction.Left -> fold(instruction)
        }
    }

    private fun Set<Dot>.fold(instruction: FoldInstruction.Up): Set<Dot> {
        val dotsToMove = filter { it.y > instruction.alongY }.toSet()
        val movedDots = dotsToMove.map { it.copy(y = it.y - 2 * (it.y - instruction.alongY)) }.toSet()
        return this - dotsToMove + movedDots
    }

    private fun Set<Dot>.fold(instruction: FoldInstruction.Left): Set<Dot> {
        val dotsToMove = filter { it.x > instruction.alongX }.toSet()
        val movedDots = dotsToMove.map { it.copy(x = it.x - 2 * (it.x - instruction.alongX)) }.toSet()
        return this - dotsToMove + movedDots
    }

}
