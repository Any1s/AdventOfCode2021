package de.mbdevelopment.adventofcode.year2021.solvers.day2

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class Day2Puzzle2Test {

    @Test
    fun `passes example from problem page`() {
        // arrange
        val input = sequenceOf(
            "forward 5",
            "down 5",
            "forward 8",
            "up 3",
            "down 8",
            "forward 2"
        )

        // act
        val result = Day2Puzzle2().solve(input)

        // assert
        assertThat(result).isEqualTo("900")
    }
}