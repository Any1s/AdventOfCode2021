package de.mbdevelopment.adventofcode.year2021

import de.mbdevelopment.adventofcode.year2021.solvers.day1.Day1Puzzle1
import de.mbdevelopment.adventofcode.year2021.solvers.day1.Day1Puzzle2
import de.mbdevelopment.adventofcode.year2021.solvers.day2.Day2Puzzle1
import de.mbdevelopment.adventofcode.year2021.solvers.day2.Day2Puzzle2
import java.io.File

val puzzles = mapOf(
    "day1puzzle1" to Day1Puzzle1(),
    "day1puzzle2" to Day1Puzzle2(),
    "day2puzzle1" to Day2Puzzle1(),
    "day2puzzle2" to Day2Puzzle2()
)

fun main(args: Array<String>) {
    val puzzle = args.first().lowercase()
    println("Solving: $puzzle")

    val resource = "puzzles${File.separator}$puzzle.txt"
    println("Reading input from: $resource")
    val inputFile = object {}.javaClass.classLoader.getResourceAsStream(resource)
        ?: throw RuntimeException("Could not open resource '$resource'")
    val inputLines = inputFile.bufferedReader().lineSequence()

    println("Result:")
    println(puzzles[puzzle]?.solve(inputLines))
}