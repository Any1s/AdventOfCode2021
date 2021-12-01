package de.mbdevelopment.adventofcode.year2021.solvers.day1

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class Day1Puzzle1Test {

    @Test
    fun `only increases in the beginning`() {
        // arrange
        val input = sequenceOf(1, 2, 3, 4, 3, 2, 1).map(Int::toString)

        // act
        val result = Day1Puzzle1().solve(input)

        // assert
        assertThat(result).isEqualTo("3")
    }

    @Test
    fun `only increases in the end`() {
        // arrange
        val input = sequenceOf(4, 3, 2, 1, 2, 3, 4).map(Int::toString)

        // act
        val result = Day1Puzzle1().solve(input)

        // assert
        assertThat(result).isEqualTo("3")
    }

    @Test
    fun `never increases for single value input`() {
        // arrange
        val input = sequenceOf(999).map(Int::toString)

        // act
        val result = Day1Puzzle1().solve(input)

        // assert
        assertThat(result).isEqualTo("0")
    }

    @Test
    fun `increases half of the time for swinging sequence`() {
        // arrange
        val input = sequenceOf(1, 2, 1, 2, 1, 2, 1, 2).map(Int::toString)

        // act
        val result = Day1Puzzle1().solve(input)

        // assert
        assertThat(result).isEqualTo("4")
    }

    @Test
    fun `increases 7 times for example input of puzzle page`() {
        // arrange
        val input = sequenceOf(199, 200, 208, 210, 200, 207, 240, 269, 260, 263).map(Int::toString)

        // act
        val result = Day1Puzzle1().solve(input)

        // assert
        assertThat(result).isEqualTo("7")
    }
}