package de.mbdevelopment.adventofcode.year2021.solvers.day11

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class Day11Puzzle1Test {

    @Test
    fun `passes example from problem page`() {
        // arrange
        val input = this::class.java.classLoader.getResourceAsStream("puzzles/day11puzzle1_example.txt")
            ?.bufferedReader()
            ?.lineSequence()
            ?: sequenceOf()

        // act
        val result = Day11Puzzle1().solve(input)

        // assert
        assertThat(result).isEqualTo("1656")
    }
}