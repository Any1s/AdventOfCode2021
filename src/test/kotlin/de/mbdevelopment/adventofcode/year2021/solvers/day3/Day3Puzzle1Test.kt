package de.mbdevelopment.adventofcode.year2021.solvers.day3

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class Day3Puzzle1Test {

    @Test
    fun `passes example from problem page`() {
        // arrange
        val input = sequenceOf(
            "00100",
            "11110",
            "10110",
            "10111",
            "10101",
            "01111",
            "00111",
            "11100",
            "10000",
            "11001",
            "00010",
            "01010"
        )

        // act
        val result = Day3Puzzle1().solve(input)

        // assert
        assertThat(result).isEqualTo("198")
    }
}