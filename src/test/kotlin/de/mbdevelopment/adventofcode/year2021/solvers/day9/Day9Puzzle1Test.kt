package de.mbdevelopment.adventofcode.year2021.solvers.day9

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class Day9Puzzle1Test {

    @Test
    fun `passes example from problem page`() {
        // arrange
        val input = this::class.java.classLoader.getResourceAsStream("puzzles/day9puzzle1_example.txt")
            ?.bufferedReader()
            ?.lineSequence()
            ?: sequenceOf()

        // act
        val result = Day9Puzzle1().solve(input)

        // assert
        assertThat(result).isEqualTo("15")
    }
}