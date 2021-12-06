package de.mbdevelopment.adventofcode.year2021.solvers.day6

import de.mbdevelopment.adventofcode.year2021.solvers.PuzzleSolver

abstract class Day6Puzzle(private val days: Int) : PuzzleSolver {

    companion object {
        private const val BABY_TIMER = 8
    }

    final override fun solve(inputLines: Sequence<String>) = lanternfishPopulationAfter80Days2(inputLines).toString();

    private fun lanternfishPopulationAfter80Days(initialPopulation: Sequence<String>): Int {
        val population = initialPopulation
            .filter { it.isNotBlank() }
            .single()
            .split(',')
            .map { it.toInt() }
            .toMutableList()

        repeat(days) {
            val newLanternfish = mutableListOf<Int>()
            population.replaceAll {
                val newTimer = it - 1
                if (newTimer < 0) {
                    newLanternfish += BABY_TIMER
                    6
                } else {
                    newTimer
                }
            }
            population += newLanternfish
        }

        return population.size
    }

    private fun lanternfishPopulationAfter80Days2(initialPopulation: Sequence<String>): Long {
        val population = initialPopulation
            .filter { it.isNotBlank() }
            .single()
            .split(',')
            .map { it.toInt() }
            .groupBy { it }
            .mapValues { it.value.size.toLong() }
            .toMutableMap()

        repeat(days) {
            val newLanternfish = population.getOrDefault(0, 0L)
            (1..8).forEach { timer ->
                population[timer - 1] = population.getOrDefault(timer, 0L)
            }
            population[8] = newLanternfish
            population[6] = population.getOrDefault(6, 0L) + newLanternfish
        }

        return population.values.reduce(Long::plus)
    }

}