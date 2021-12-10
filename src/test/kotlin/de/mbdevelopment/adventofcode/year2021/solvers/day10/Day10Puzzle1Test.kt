package de.mbdevelopment.adventofcode.year2021.solvers.day10

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class Day10Puzzle1Test {

    @Test
    fun `passes example from problem page`() {
        // arrange
        val input = this::class.java.classLoader.getResourceAsStream("puzzles/day10puzzle1_example.txt")
            ?.bufferedReader()
            ?.lineSequence()
            ?: sequenceOf()

        // act
        val result = Day10Puzzle1().solve(input)

        // assert
        assertThat(result).isEqualTo("26397")
    }
}