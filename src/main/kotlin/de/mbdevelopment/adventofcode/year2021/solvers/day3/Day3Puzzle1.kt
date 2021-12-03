package de.mbdevelopment.adventofcode.year2021.solvers.day3

import de.mbdevelopment.adventofcode.year2021.solvers.PuzzleSolver

class Day3Puzzle1 : PuzzleSolver {

    override fun solve(inputLines: Sequence<String>) = powerConsumption(inputLines).toString();

    private fun powerConsumption(diagnosticReport: Sequence<String>) = diagnosticReport
        .map { it.toCharArray() }
        .map { it.map { digit -> digit.digitToInt() } }
        .reduce { a, b -> a.mapIndexed { index, value -> value + if (b[index] == 1) 1 else -1 } }
        .map { if (it > 0) 1 else 0 }
        .joinToString(separator = "")
        .run { this to this.map { it.digitToInt() }.map { if (it == 1) 0 else 1 }.joinToString(separator = "") }
        .run { first.toInt(2) * second.toInt(2) }

}