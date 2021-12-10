package de.mbdevelopment.adventofcode.year2021.solvers.day10

import java.util.*

class Day10Puzzle2 : Day10Puzzle() {

    companion object {
        private val missingCharacterScores = mapOf(
            ')' to 1,
            ']' to 2,
            '}' to 3,
            '>' to 4
        )
    }

    override fun score(sourceCode: Sequence<String>): Long {
        val scores = sourceCode
            .filter { firstIllegalCharacter(it) == null }
            .map { missingCharacters(it) }
            .map { scoreMissingCharacters(it) }
            .sorted()
            .toList()

        return scores[scores.size / 2]
    }

    private fun missingCharacters(lineOfCode: String): String {
        val expectedChunkEnds = LinkedList<Char>()
        for (char in lineOfCode) {
            if (char in chunkStarts) {
                expectedChunkEnds.push(chunks[char]!!)
            } else {
                expectedChunkEnds.remove()
            }
        }
        return expectedChunkEnds.joinToString("")
    }

    private fun scoreMissingCharacters(missingCharacters: String) = missingCharacters
        .fold(0L) { a, b -> a * 5 + missingCharacterScores[b]!! }

}