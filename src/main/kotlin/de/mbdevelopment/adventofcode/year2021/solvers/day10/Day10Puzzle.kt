package de.mbdevelopment.adventofcode.year2021.solvers.day10

import de.mbdevelopment.adventofcode.year2021.solvers.PuzzleSolver
import java.util.*

abstract class Day10Puzzle : PuzzleSolver {

    companion object {

        @JvmStatic
        protected val chunks = mapOf(
            '(' to ')',
            '[' to ']',
            '{' to '}',
            '<' to '>'
        )

        @JvmStatic
        protected val chunkStarts = setOf('(', '[', '{', '<')
    }

    final override fun solve(inputLines: Sequence<String>) = score(inputLines.filter { it.isNotBlank() }).toString()

    abstract fun score(sourceCode: Sequence<String>): Long

    protected fun firstIllegalCharacter(lineOfCode: String): Char? {
        val expectedChunkEnds = LinkedList<Char>()
        for (char in lineOfCode) {
            if (char in chunkStarts) {
                expectedChunkEnds.push(chunks[char]!!)
            } else {
                if (char != expectedChunkEnds.pop()) {
                    return char
                }
            }
        }

        return null
    }

}