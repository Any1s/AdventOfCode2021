package de.mbdevelopment.adventofcode.year2021.solvers.day16

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class Day16Puzzle2Test {

    @Test
    fun `passes example 1 from problem page`() {
        // arrange
        val input = sequenceOf("C200B40A82")

        // act
        val result = Day16Puzzle2().solve(input)

        // assert
        assertThat(result).isEqualTo("3")
    }

    @Test
    fun `passes example 2 from problem page`() {
        // arrange
        val input = sequenceOf("04005AC33890")

        // act
        val result = Day16Puzzle2().solve(input)

        // assert
        assertThat(result).isEqualTo("54")
    }

    @Test
    fun `passes example 3 from problem page`() {
        // arrange
        val input = sequenceOf("880086C3E88112")

        // act
        val result = Day16Puzzle2().solve(input)

        // assert
        assertThat(result).isEqualTo("7")
    }

    @Test
    fun `passes example 4 from problem page`() {
        // arrange
        val input = sequenceOf("CE00C43D881120")

        // act
        val result = Day16Puzzle2().solve(input)

        // assert
        assertThat(result).isEqualTo("9")
    }

    @Test
    fun `passes example 5 from problem page`() {
        // arrange
        val input = sequenceOf("D8005AC2A8F0")

        // act
        val result = Day16Puzzle2().solve(input)

        // assert
        assertThat(result).isEqualTo("1")
    }

    @Test
    fun `passes example 6 from problem page`() {
        // arrange
        val input = sequenceOf("F600BC2D8F")

        // act
        val result = Day16Puzzle2().solve(input)

        // assert
        assertThat(result).isEqualTo("0")
    }

    @Test
    fun `passes example 7 from problem page`() {
        // arrange
        val input = sequenceOf("9C005AC2F8F0")

        // act
        val result = Day16Puzzle2().solve(input)

        // assert
        assertThat(result).isEqualTo("0")
    }

    @Test
    fun `passes example 8 from problem page`() {
        // arrange
        val input = sequenceOf("9C0141080250320F1802104A08")

        // act
        val result = Day16Puzzle2().solve(input)

        // assert
        assertThat(result).isEqualTo("1")
    }
}