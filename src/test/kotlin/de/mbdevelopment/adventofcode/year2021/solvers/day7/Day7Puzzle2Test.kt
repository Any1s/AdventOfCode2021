package de.mbdevelopment.adventofcode.year2021.solvers.day7

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class Day7Puzzle2Test {

    @Test
    fun `passes example from problem page`() {
        // arrange
        val input = sequenceOf("16,1,2,0,4,2,7,1,2,14")

        // act
        val result = Day7Puzzle2().solve(input)

        // assert
        assertThat(result).isEqualTo("168")
    }

    @Test
    fun `passes for odd number of input`() {
        // arrange
        val input = sequenceOf("1,2,6")

        // act
        val result = Day7Puzzle2().solve(input)

        // assert
        assertThat(result).isEqualTo("10")
    }

    @Test
    fun `passes for even number of input`() {
        // arrange
        val input = sequenceOf("1,2,3,6")

        // act
        val result = Day7Puzzle2().solve(input)

        // assert
        assertThat(result).isEqualTo("10")
    }
}