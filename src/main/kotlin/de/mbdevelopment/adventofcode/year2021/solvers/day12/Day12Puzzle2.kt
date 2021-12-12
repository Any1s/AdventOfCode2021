package de.mbdevelopment.adventofcode.year2021.solvers.day12

class Day12Puzzle2 : Day12Puzzle() {

    override fun countWaysThroughCaves(caveConnections: Map<Cave, Set<Cave>>) = caveConnections.keys
        .filterIsInstance<Cave.SmallCave>()
        .minus(setOf(START, END))
        .flatMap { waysThroughCaves(caveConnections, listOf(START), it) }
        .distinct()
        .size

    private fun waysThroughCaves(
        caveConnections: Map<Cave, Set<Cave>>,
        currentPath: List<Cave>,
        specialSmallCave: Cave,
        visitsToSpecialCave: Int = 0
    ): List<List<Cave>> {
        return if (currentPath.last() == END) {
            listOf(currentPath)
        } else {
            val forbiddenCaves = currentPath
                .filterIsInstance<Cave.SmallCave>()
                .filter { it != specialSmallCave || (it == specialSmallCave && visitsToSpecialCave > 1) }
                .toSet()
            caveConnections[currentPath.last()]
                ?.minus(forbiddenCaves)
                ?.flatMap {
                    waysThroughCaves(
                        caveConnections,
                        currentPath + it,
                        specialSmallCave,
                        if (currentPath.last() == specialSmallCave) visitsToSpecialCave + 1 else visitsToSpecialCave
                    )
                }
                ?: throw IllegalArgumentException("Cave $currentPath does not have any connections.")
        }
    }

}
