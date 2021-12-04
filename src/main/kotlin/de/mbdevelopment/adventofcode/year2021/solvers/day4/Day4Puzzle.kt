package de.mbdevelopment.adventofcode.year2021.solvers.day4

import de.mbdevelopment.adventofcode.year2021.solvers.PuzzleSolver

abstract class Day4Puzzle : PuzzleSolver {

    abstract fun solve(drawnNumbers: List<Int>, boards: List<BingoBoard>): Int

    final override fun solve(inputLines: Sequence<String>): String {
        val gameConfiguration = inputLines.toList()
        return solve(parseDrawnNumbers(gameConfiguration), parseBoards(gameConfiguration)).toString()
    }

    private fun parseDrawnNumbers(bingoGame: List<String>) = bingoGame.first()
        .split(',')
        .map { it.toInt() }

    private fun parseBoards(bingoGame: List<String>) = bingoGame.drop(1)
        .filter { it.isNotBlank() }
        .windowed(5, 5)
        .map { it.toBingoBoard() }

    private fun List<String>.toBingoBoard() = this.map { row ->
        row.split(' ').filter { it.isNotBlank() }.map { BoardEntry(it.toInt()) }
    }.run { BingoBoard(this) }
}