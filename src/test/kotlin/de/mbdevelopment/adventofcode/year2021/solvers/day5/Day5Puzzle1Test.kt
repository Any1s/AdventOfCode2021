package de.mbdevelopment.adventofcode.year2021.solvers.day5

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

internal class Day5Puzzle1Test {

    @Test
    fun `passes example from problem page`() {
        // arrange
        val input = this::class.java.classLoader.getResourceAsStream("puzzles/day5puzzle1_example.txt")
            ?.bufferedReader()
            ?.lineSequence()
            ?: sequenceOf()

        // act
        val result = Day5Puzzle1().solve(input)

        // assert
        Assertions.assertThat(result).isEqualTo("5")
    }
}