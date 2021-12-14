package de.mbdevelopment.adventofcode.year2021.solvers.day14

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class Day14Puzzle2Test {

    @Test
    fun `passes example from problem page`() {
        // arrange
        val input = this::class.java.classLoader.getResourceAsStream("puzzles/day14puzzle_example.txt")
            ?.bufferedReader()
            ?.lineSequence()
            ?: sequenceOf()

        // act
        val result = Day14Puzzle2().solve(input)

        // assert
        assertThat(result).isEqualTo("2188189693529")
    }
}