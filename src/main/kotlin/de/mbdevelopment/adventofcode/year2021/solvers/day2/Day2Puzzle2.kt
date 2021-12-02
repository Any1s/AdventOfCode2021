package de.mbdevelopment.adventofcode.year2021.solvers.day2

import de.mbdevelopment.adventofcode.year2021.solvers.PuzzleSolver

class Day2Puzzle2 : PuzzleSolver {

    override fun solve(inputLines: Sequence<String>) = productOfSumOfDirections(inputLines).toString();

    private fun productOfSumOfDirections(directions: Sequence<String>) = directions
        .map { it.split(" ") }
        .map { toShift(it[0], it[1].toInt()) }
        .fold(Coordinates(0, 0, 0)) { coordinates, shift -> shift(coordinates) }
        .let { it.horizontalPosition * it.depth }

    private fun toShift(direction: String, amount: Int) = when (direction) {
        "forward" -> { coordinates: Coordinates ->
            with(coordinates) {
                Coordinates(horizontalPosition + amount, depth + aim * amount, aim)
            }
        }
        "down" -> { coordinates: Coordinates ->
            with(coordinates) {
                Coordinates(horizontalPosition, depth, aim + amount)
            }
        }
        "up" -> { coordinates: Coordinates ->
            with(coordinates) {
                Coordinates(horizontalPosition, depth, aim - amount)
            }
        }
        else -> { coordinates: Coordinates -> coordinates }
    }

    private data class Coordinates(val horizontalPosition: Int, val depth: Int, val aim: Int)
}