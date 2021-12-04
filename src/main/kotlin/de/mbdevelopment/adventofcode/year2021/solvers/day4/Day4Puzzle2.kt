package de.mbdevelopment.adventofcode.year2021.solvers.day4

class Day4Puzzle2 : Day4Puzzle() {

    override fun solve(drawnNumbers: List<Int>, boards: List<BingoBoard>): Int {
        val remainingBoards = boards.toMutableList();

        var lastWinningScore: Int? = null
        for (drawnNumber in drawnNumbers) {
            val winningBoards = remainingBoards.onEach { it.mark(drawnNumber) }
                .map { it to it.winningSum() }
                .filter { it.second != null }
            winningBoards.lastOrNull()?.let { lastWinningScore = it.second?.times(drawnNumber) }

            remainingBoards.removeAll(winningBoards.map { it.first })
        }

        return lastWinningScore ?: throw IllegalArgumentException("Bingo game has no winner")
    }

}
