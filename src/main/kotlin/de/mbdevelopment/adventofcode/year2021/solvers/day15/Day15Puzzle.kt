package de.mbdevelopment.adventofcode.year2021.solvers.day15

import de.mbdevelopment.adventofcode.year2021.solvers.PuzzleSolver
import java.util.*

abstract class Day15Puzzle : PuzzleSolver {

    final override fun solve(inputLines: Sequence<String>) = lowestPathRisk(inputLines.toList()).toString()

    abstract fun getRiskMapFromTile(tile: List<List<Node>>): List<List<Node>>

    // Dijkstra with priority queue flavor
    private fun lowestPathRisk(costOfEntering: List<String>): Long {
        val riskMapTile = inputToTile(costOfEntering)
        val riskMap = getRiskMapFromTile(riskMapTile)

        val start = riskMap.first().first() // top left
        val target = riskMap.last().last() // bottom right
        val nodes = riskMap.flatten().toSet()

        val minimumRisk = mutableMapOf<Node, Long>().apply { put(start, 0L) }
        for (node in nodes - start) {
            minimumRisk[node] = Long.MAX_VALUE
        }
        val predecessor = mutableMapOf<Node, Node>()

        val searchQueue =
            PriorityQueue<Node>(nodes.size) { a, b -> minimumRisk[a]!!.compareTo(minimumRisk[b]!!) }
        searchQueue.addAll(nodes)

        while (searchQueue.isNotEmpty()) {
            val lowestTargetRiskNode = searchQueue.remove()
            with(lowestTargetRiskNode) {
                listOfNotNull(
                    riskMap[y].getOrNull(x - 1),  // left
                    riskMap[y].getOrNull(x + 1),  // right
                    riskMap.getOrNull(y - 1)?.get(x),  // above
                    riskMap.getOrNull(y + 1)?.get(x)  // below
                ).forEach { neighbor ->
                    val alternativePathRisk = minimumRisk[lowestTargetRiskNode]!! +
                            neighbor.riskOfEntering
                    if (alternativePathRisk < minimumRisk[neighbor]!!) {
                        minimumRisk[neighbor] = alternativePathRisk
                        predecessor[neighbor] = lowestTargetRiskNode
                        // Change position in priority queue based on new risk
                        searchQueue.remove(neighbor)
                        searchQueue.add(neighbor)
                    }
                }
            }
        }

        return minimumRisk[target]!!
    }

    private fun inputToTile(costOfEntering: List<String>) = costOfEntering
        .filter { it.isNotBlank() }
        .mapIndexed { y, row ->
            row.mapIndexed { x, riskOfEntering ->
                Node(x, y, riskOfEntering.digitToInt())
            }
        }

}
