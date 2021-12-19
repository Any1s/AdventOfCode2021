package de.mbdevelopment.adventofcode.year2021.solvers.day19

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class Day19Puzzle1Test {

    @Test
    fun `passes example from problem page`() {
        // arrange
        val input = this::class.java.classLoader.getResourceAsStream("puzzles/day19puzzle_example.txt")
            ?.bufferedReader()
            ?.lineSequence()
            ?: sequenceOf()

        // act
        val result = Day19Puzzle1().solve(input)

        // assert
        assertThat(result).isEqualTo("79")
    }
}