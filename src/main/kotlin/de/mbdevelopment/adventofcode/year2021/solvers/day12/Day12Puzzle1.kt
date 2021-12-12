package de.mbdevelopment.adventofcode.year2021.solvers.day12

class Day12Puzzle1 : Day12Puzzle() {

    override fun countWaysThroughCaves(caveConnections: Map<Cave, Set<Cave>>) =
        waysThroughCaves(caveConnections, listOf(START)).size

    private fun waysThroughCaves(
        caveConnections: Map<Cave, Set<Cave>>,
        currentPath: List<Cave>
    ): List<List<Cave>> {
        return if (currentPath.last() == END) {
            listOf(currentPath)
        } else {
            caveConnections[currentPath.last()]
                ?.minus(currentPath.filterIsInstance<Cave.SmallCave>().toSet())
                ?.flatMap { waysThroughCaves(caveConnections, currentPath + it) }
                ?: throw IllegalArgumentException("Cave $currentPath does not have any connections.")
        }
    }

}
