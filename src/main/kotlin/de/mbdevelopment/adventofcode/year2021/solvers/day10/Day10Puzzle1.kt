package de.mbdevelopment.adventofcode.year2021.solvers.day10

class Day10Puzzle1 : Day10Puzzle() {

    companion object {
        private val illegalCharacterScores = mapOf(
            ')' to 3,
            ']' to 57,
            '}' to 1197,
            '>' to 25137
        )
    }

    override fun score(sourceCode: Sequence<String>) = sourceCode
        .mapNotNull { firstIllegalCharacter(it) }
        .mapNotNull { illegalCharacterScores[it] }
        .fold(0, Int::plus)
        .toLong()

}