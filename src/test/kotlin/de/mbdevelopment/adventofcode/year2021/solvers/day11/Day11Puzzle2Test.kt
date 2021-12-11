package de.mbdevelopment.adventofcode.year2021.solvers.day11

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

internal class Day11Puzzle2Test {

    @Test
    fun `passes example from problem page`() {
        // arrange
        val input = this::class.java.classLoader.getResourceAsStream("puzzles/day11puzzle2_example.txt")
            ?.bufferedReader()
            ?.lineSequence()
            ?: sequenceOf()

        // act
        val result = Day11Puzzle2().solve(input)

        // assert
        Assertions.assertThat(result).isEqualTo("195")
    }
}