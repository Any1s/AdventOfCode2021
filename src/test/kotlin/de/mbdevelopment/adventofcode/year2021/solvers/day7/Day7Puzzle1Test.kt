package de.mbdevelopment.adventofcode.year2021.solvers.day7

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class Day7Puzzle1Test {

    @Test
    fun `passes example from problem page`() {
        // arrange
        val input = sequenceOf("16,1,2,0,4,2,7,1,2,14")

        // act
        val result = Day7Puzzle1().solve(input)

        // assert
        assertThat(result).isEqualTo("37")
    }

    @Test
    fun `passes example from problem page with one less input`() {
        // arrange
        val input = sequenceOf("16,1,2,0,4,2,7,1,14")

        // act
        val result = Day7Puzzle1().solve(input)

        // assert
        assertThat(result).isEqualTo("37")
    }
}