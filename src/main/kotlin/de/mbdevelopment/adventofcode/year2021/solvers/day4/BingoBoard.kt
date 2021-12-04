package de.mbdevelopment.adventofcode.year2021.solvers.day4

class BingoBoard(private val entries: List<List<BoardEntry>>) {

    fun mark(drawnNumber: Int) =
        entries.forEach { row -> row.forEach { if (it.number == drawnNumber) it.drawn = true } }

    fun winningSum(): Int? {
        val hasWinningRow = entries.map { row ->
            row.map { it.drawn }.reduce { a, b -> a && b }
        }.any { it }

        val hasWinningColumn = (0..4).map { columnIndex ->
            var columnWins = true;
            (0..4).forEach { rowIndex ->
                columnWins = entries[rowIndex][columnIndex].drawn && columnWins
            }
            columnWins
        }.any { it }

        return if (hasWinningRow || hasWinningColumn) {
            entries.map { row -> row.map { if (!it.drawn) it.number else 0 }.reduce(Int::plus) }
                .reduce(Int::plus)
        } else null
    }
}

data class BoardEntry(val number: Int, var drawn: Boolean = false)