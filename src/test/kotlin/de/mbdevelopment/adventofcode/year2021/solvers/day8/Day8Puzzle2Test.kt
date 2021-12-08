package de.mbdevelopment.adventofcode.year2021.solvers.day8

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test


internal class Day8Puzzle2Test {

    @Test
    fun `passes example from problem page`() {
        // arrange
        val input = this::class.java.classLoader.getResourceAsStream("puzzles/day8puzzle2_example.txt")
            ?.bufferedReader()
            ?.lineSequence()
            ?: sequenceOf()

        // act
        val result = Day8Puzzle2().solve(input)

        // assert
        assertThat(result).isEqualTo("61229")
    }
}