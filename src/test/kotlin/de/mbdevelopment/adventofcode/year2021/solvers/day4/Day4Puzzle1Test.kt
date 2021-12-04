package de.mbdevelopment.adventofcode.year2021.solvers.day4

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class Day4Puzzle1Test {

    @Test
    fun `passes example from problem page`() {
        // arrange
        val input = this::class.java.classLoader.getResourceAsStream("puzzles/day4puzzle1_example.txt")
            ?.bufferedReader()
            ?.lineSequence()
            ?: sequenceOf()

        // act
        val result = Day4Puzzle1().solve(input)

        // assert
        assertThat(result).isEqualTo("4512")
    }

    @Test
    fun `column wins`() {
        // arrange
        val input = this::class.java.classLoader.getResourceAsStream("puzzles/day4puzzle1_columWins.txt")
            ?.bufferedReader()
            ?.lineSequence()
            ?: sequenceOf()

        // act
        val result = Day4Puzzle1().solve(input)

        // assert
        val expectedResult = (7 * 5 * 4 * 2).toString()
        assertThat(result).isEqualTo(expectedResult)
    }
}