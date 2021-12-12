package de.mbdevelopment.adventofcode.year2021.solvers.day12

import de.mbdevelopment.adventofcode.year2021.solvers.PuzzleSolver

abstract class Day12Puzzle : PuzzleSolver {

    companion object {
        @JvmStatic
        protected val START = Cave.SmallCave("start")

        @JvmStatic
        protected val END = Cave.SmallCave("end")
    }

    final override fun solve(inputLines: Sequence<String>) =
        countWaysThroughCaves(collectCaveConnections(inputLines)).toString()

    abstract fun countWaysThroughCaves(caveConnections: Map<Cave, Set<Cave>>): Int

    private fun collectCaveConnections(caveSystem: Sequence<String>) = caveSystem
        .filter { it.isNotBlank() }
        .map { it.split('-') }
        .map { it.map { cave -> if (cave == cave.lowercase()) Cave.SmallCave(cave) else Cave.BigCave(cave) } }
        .map { it[0] to it[1] }
        .toList()
        .let { connections ->
            val aToB = connections.groupBy { it.first }
                .mapValues { it.value.map { connection -> connection.second }.toSet() }
            val bToA = connections.groupBy { it.second }
                .mapValues { it.value.map { connection -> connection.first }.toSet() }

            aToB.toMutableMap().apply {
                bToA.forEach { (key, value) ->
                    put(key, getOrDefault(key, emptySet()) + value)
                }
            }.toMap()
        }

}
