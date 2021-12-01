package de.mbdevelopment.adventofcode.year2021.solvers.day1

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

internal class Day1Puzzle2Test {

    @Test
    fun `increases 5 times for example input of puzzle page`() {
        // arrange
        val input = sequenceOf(199, 200, 208, 210, 200, 207, 240, 269, 260, 263).map(Int::toString)

        // act
        val result = Day1Puzzle2().solve(input)

        // assert
        Assertions.assertThat(result).isEqualTo("5")
    }
}