package de.mbdevelopment.adventofcode.year2021

import de.mbdevelopment.adventofcode.year2021.solvers.day1.Day1Puzzle1
import de.mbdevelopment.adventofcode.year2021.solvers.day1.Day1Puzzle2
import de.mbdevelopment.adventofcode.year2021.solvers.day10.Day10Puzzle1
import de.mbdevelopment.adventofcode.year2021.solvers.day10.Day10Puzzle2
import de.mbdevelopment.adventofcode.year2021.solvers.day11.Day11Puzzle1
import de.mbdevelopment.adventofcode.year2021.solvers.day11.Day11Puzzle2
import de.mbdevelopment.adventofcode.year2021.solvers.day12.Day12Puzzle1
import de.mbdevelopment.adventofcode.year2021.solvers.day12.Day12Puzzle2
import de.mbdevelopment.adventofcode.year2021.solvers.day13.Day13Puzzle1
import de.mbdevelopment.adventofcode.year2021.solvers.day13.Day13Puzzle2
import de.mbdevelopment.adventofcode.year2021.solvers.day14.Day14Puzzle1
import de.mbdevelopment.adventofcode.year2021.solvers.day14.Day14Puzzle2
import de.mbdevelopment.adventofcode.year2021.solvers.day2.Day2Puzzle1
import de.mbdevelopment.adventofcode.year2021.solvers.day2.Day2Puzzle2
import de.mbdevelopment.adventofcode.year2021.solvers.day3.Day3Puzzle1
import de.mbdevelopment.adventofcode.year2021.solvers.day3.Day3Puzzle2
import de.mbdevelopment.adventofcode.year2021.solvers.day4.Day4Puzzle1
import de.mbdevelopment.adventofcode.year2021.solvers.day4.Day4Puzzle2
import de.mbdevelopment.adventofcode.year2021.solvers.day5.Day5Puzzle1
import de.mbdevelopment.adventofcode.year2021.solvers.day5.Day5Puzzle2
import de.mbdevelopment.adventofcode.year2021.solvers.day6.Day6Puzzle1
import de.mbdevelopment.adventofcode.year2021.solvers.day6.Day6Puzzle2
import de.mbdevelopment.adventofcode.year2021.solvers.day7.Day7Puzzle1
import de.mbdevelopment.adventofcode.year2021.solvers.day7.Day7Puzzle2
import de.mbdevelopment.adventofcode.year2021.solvers.day8.Day8Puzzle1
import de.mbdevelopment.adventofcode.year2021.solvers.day8.Day8Puzzle2
import de.mbdevelopment.adventofcode.year2021.solvers.day9.Day9Puzzle1
import de.mbdevelopment.adventofcode.year2021.solvers.day9.Day9Puzzle2
import java.io.File

val puzzles = mapOf(
    "day1puzzle1" to Day1Puzzle1(),
    "day1puzzle2" to Day1Puzzle2(),
    "day2puzzle1" to Day2Puzzle1(),
    "day2puzzle2" to Day2Puzzle2(),
    "day3puzzle1" to Day3Puzzle1(),
    "day3puzzle2" to Day3Puzzle2(),
    "day4puzzle1" to Day4Puzzle1(),
    "day4puzzle2" to Day4Puzzle2(),
    "day5puzzle1" to Day5Puzzle1(),
    "day5puzzle2" to Day5Puzzle2(),
    "day6puzzle1" to Day6Puzzle1(),
    "day6puzzle2" to Day6Puzzle2(),
    "day7puzzle1" to Day7Puzzle1(),
    "day7puzzle2" to Day7Puzzle2(),
    "day8puzzle1" to Day8Puzzle1(),
    "day8puzzle2" to Day8Puzzle2(),
    "day9puzzle1" to Day9Puzzle1(),
    "day9puzzle2" to Day9Puzzle2(),
    "day10puzzle1" to Day10Puzzle1(),
    "day10puzzle2" to Day10Puzzle2(),
    "day11puzzle1" to Day11Puzzle1(),
    "day11puzzle2" to Day11Puzzle2(),
    "day12puzzle1" to Day12Puzzle1(),
    "day12puzzle2" to Day12Puzzle2(),
    "day13puzzle1" to Day13Puzzle1(),
    "day13puzzle2" to Day13Puzzle2(),
    "day14puzzle1" to Day14Puzzle1(),
    "day14puzzle2" to Day14Puzzle2(),
)

fun main(args: Array<String>) {
    val puzzle = args.first().lowercase()
    val solver = puzzles[puzzle]
    if (solver == null) {
        println("No solver found for: $puzzle")
        return
    }
    println("Solving: $puzzle with ${solver::class.simpleName}")

    val resource = "puzzles${File.separator}$puzzle.txt"
    println("Reading input from: $resource")
    val inputFile = object {}.javaClass.classLoader.getResourceAsStream(resource)
        ?: throw RuntimeException("Could not open resource '$resource'")
    inputFile.bufferedReader().useLines {
        println("Result:")
        println(puzzles[puzzle]?.solve(it))
    }
}