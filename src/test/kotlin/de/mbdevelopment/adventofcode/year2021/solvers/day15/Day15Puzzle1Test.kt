package de.mbdevelopment.adventofcode.year2021.solvers.day15

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class Day15Puzzle1Test {

    @Test
    fun `passes example from problem page`() {
        // arrange
        val input = this::class.java.classLoader.getResourceAsStream("puzzles/day15puzzle_example.txt")
            ?.bufferedReader()
            ?.lineSequence()
            ?: sequenceOf()

        // act
        val result = Day15Puzzle1().solve(input)

        // assert
        assertThat(result).isEqualTo("40")
    }
}