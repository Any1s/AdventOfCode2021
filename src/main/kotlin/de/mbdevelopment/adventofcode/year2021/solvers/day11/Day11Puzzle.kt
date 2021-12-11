package de.mbdevelopment.adventofcode.year2021.solvers.day11

import de.mbdevelopment.adventofcode.year2021.solvers.PuzzleSolver

abstract class Day11Puzzle : PuzzleSolver {

    final override fun solve(inputLines: Sequence<String>) = simulate(
        inputLines.map { row -> row.map { it.digitToInt() } }
            .map { it.toMutableList() }
            .toList())
        .toString()

    abstract fun simulate(octopusGrid: List<MutableList<Int>>): Int

    protected fun step(octopusGrid: List<MutableList<Int>>): Int {
        octopusGrid.chargeOne()
        val flashed = octopusGrid.flashCascading()
        octopusGrid.reset(flashed)

        return flashed.size
    }

    private fun List<MutableList<Int>>.chargeOne() {
        forEachIndexed { y, row ->
            row.forEachIndexed { x, energyLevel ->
                this[y][x] = energyLevel + 1
            }
        }
    }

    private fun List<MutableList<Int>>.flashCascading(): Set<Point> {
        val flashed = mutableSetOf<Point>()
        var candidates = flashCandidates()
        while (!flashed.containsAll(candidates)) {
            (candidates - flashed).forEach { flash(it) }
            flashed += candidates
            candidates = flashCandidates()
        }

        return flashed
    }

    private fun List<MutableList<Int>>.flashCandidates() =
        flatMapIndexed { y, row ->
            row.mapIndexedNotNull { x, energyLevel ->
                if (energyLevel > 9) Point(x, y) else null
            }
        }.toSet()

    private fun List<MutableList<Int>>.flash(octopus: Point) {
        ((octopus.x - 1)..(octopus.x + 1)).forEach { x ->
            ((octopus.y - 1)..(octopus.y + 1)).forEach { y ->
                if (x >= 0 && y >= 0 && y < size && x < first().size) {
                    this[y][x] = this[y][x] + 1
                }
            }
        }
    }

    private fun List<MutableList<Int>>.reset(flashed: Set<Point>) {
        forEachIndexed { y, row ->
            row.forEachIndexed { x, _ ->
                if (Point(x, y) in flashed) this[y][x] = 0
            }
        }
    }

}

data class Point(val x: Int, val y: Int)
