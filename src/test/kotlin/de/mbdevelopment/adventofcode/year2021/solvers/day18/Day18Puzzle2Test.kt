package de.mbdevelopment.adventofcode.year2021.solvers.day18

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class Day18Puzzle2Test {

    @Test
    fun `passes example from problem page`() {
        // arrange
        val input = this::class.java.classLoader.getResourceAsStream("puzzles/day18puzzle_example.txt")
            ?.bufferedReader()
            ?.lineSequence()
            ?: sequenceOf()

        // act
        val result = Day18Puzzle2().solve(input)

        // assert
        assertThat(result).isEqualTo("3993")
    }
}