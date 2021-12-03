package de.mbdevelopment.adventofcode.year2021.solvers.day3

import de.mbdevelopment.adventofcode.year2021.solvers.PuzzleSolver

class Day3Puzzle2 : PuzzleSolver {

    override fun solve(inputLines: Sequence<String>) = lifeSupportRating(inputLines).toString();

    private fun lifeSupportRating(diagnosticReport: Sequence<String>): Int {
        val readings = diagnosticReport
            .map { it.toCharArray() }
            .map { it.map { digit -> digit.digitToInt() } }
            .toList()

        val oxygenGeneratorRating = readings.filterBySignificantBitSelector({ if (it >= 0) 1 else 0 })
            .bitVectorToInt()
        val co2ScrubberRating = readings.filterBySignificantBitSelector({ if (it >= 0) 0 else 1 })
            .bitVectorToInt()

        return oxygenGeneratorRating * co2ScrubberRating
    }

    private fun List<List<Int>>.filterBySignificantBitSelector(
        bitIndexSumToSignificantBit: (Int) -> Int,
        index: Int = 0
    ): List<Int> {
        return if (size == 1 || index == first().size) {
            single()
        } else {
            val selectionBit = map { it[index] }
                .map { if(it == 1) 1 else -1 }
                .reduce(Int::plus)
                .run(bitIndexSumToSignificantBit)

            filter { it[index] == selectionBit }.filterBySignificantBitSelector(bitIndexSumToSignificantBit, index + 1)
        }
    }

    private fun List<Int>.bitVectorToInt() = joinToString("").toInt(2)

}