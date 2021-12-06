package de.mbdevelopment.adventofcode.year2021.solvers.day6

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class Day6Puzzle1Test {

    @Test
    fun `passes example from problem page`() {
        // arrange
        val input = sequenceOf("3,4,3,1,2")

        // act
        val result = Day6Puzzle1().solve(input)

        // assert
        assertThat(result).isEqualTo("5934")
    }
}