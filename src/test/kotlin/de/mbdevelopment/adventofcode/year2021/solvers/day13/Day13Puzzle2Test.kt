package de.mbdevelopment.adventofcode.year2021.solvers.day13

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class Day13Puzzle2Test {

    @Test
    fun `passes example from problem page`() {
        // arrange
        val input = this::class.java.classLoader.getResourceAsStream("puzzles/day13puzzle_example.txt")
            ?.bufferedReader()
            ?.lineSequence()
            ?: sequenceOf()

        // act
        val result = Day13Puzzle2().solve(input)

        // assert
        assertThat(result).isEqualTo("""
            #####
            #...#
            #...#
            #...#
            #####
        """.trimIndent())
    }
}