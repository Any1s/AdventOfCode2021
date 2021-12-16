package de.mbdevelopment.adventofcode.year2021.solvers.day16

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class Day16Puzzle1Test {

    @Test
    fun `passes example 1 from problem page`() {
        // arrange
        val input = sequenceOf("8A004A801A8002F478")

        // act
        val result = Day16Puzzle1().solve(input)

        // assert
        assertThat(result).isEqualTo("16")
    }

    @Test
    fun `passes example 2 from problem page`() {
        // arrange
        val input = sequenceOf("620080001611562C8802118E34")

        // act
        val result = Day16Puzzle1().solve(input)

        // assert
        assertThat(result).isEqualTo("12")
    }

    @Test
    fun `passes example 3 from problem page`() {
        // arrange
        val input = sequenceOf("C0015000016115A2E0802F182340")

        // act
        val result = Day16Puzzle1().solve(input)

        // assert
        assertThat(result).isEqualTo("23")
    }

    @Test
    fun `passes example 4 from problem page`() {
        // arrange
        val input = sequenceOf("A0016C880162017C3686B18A3D4780")

        // act
        val result = Day16Puzzle1().solve(input)

        // assert
        assertThat(result).isEqualTo("31")
    }
}