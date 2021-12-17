package de.mbdevelopment.adventofcode.year2021.solvers.day17

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class Day17Puzzle2Test {

    @Test
    fun `passes example from problem page`() {
        // arrange
        val input = sequenceOf("target area: x=20..30, y=-10..-5")

        // act
        val result = Day17Puzzle2().solve(input)

        // assert
        assertThat(result).isEqualTo("112")
    }
}