package de.mbdevelopment.adventofcode.year2021.solvers.day4

class Day4Puzzle1 : Day4Puzzle() {

    override fun solve(drawnNumbers: List<Int>, boards: List<BingoBoard>): Int {
        for (drawnNumber in drawnNumbers) {
            val winningSum = boards.onEach { it.mark(drawnNumber) }
                .map { it.winningSum() }
                .firstOrNull { it != null }

            if (winningSum != null) return winningSum * drawnNumber
        }

        return 0;
    }

}