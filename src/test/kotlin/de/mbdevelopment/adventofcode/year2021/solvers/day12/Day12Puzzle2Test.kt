package de.mbdevelopment.adventofcode.year2021.solvers.day12

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class Day12Puzzle2Test {

    @Test
    fun `passes example 1 from problem page`() {
        // arrange
        val input = this::class.java.classLoader.getResourceAsStream("puzzles/day12puzzle_example1.txt")
            ?.bufferedReader()
            ?.lineSequence()
            ?: sequenceOf()

        // act
        val result = Day12Puzzle2().solve(input)

        // assert
        assertThat(result).isEqualTo("36")
    }

    @Test
    fun `passes example 2 from problem page`() {
        // arrange
        val input = this::class.java.classLoader.getResourceAsStream("puzzles/day12puzzle_example2.txt")
            ?.bufferedReader()
            ?.lineSequence()
            ?: sequenceOf()

        // act
        val result = Day12Puzzle2().solve(input)

        // assert
        assertThat(result).isEqualTo("103")
    }

    @Test
    fun `passes example 3 from problem page`() {
        // arrange
        val input = this::class.java.classLoader.getResourceAsStream("puzzles/day12puzzle_example3.txt")
            ?.bufferedReader()
            ?.lineSequence()
            ?: sequenceOf()

        // act
        val result = Day12Puzzle2().solve(input)

        // assert
        assertThat(result).isEqualTo("3509")
    }
}