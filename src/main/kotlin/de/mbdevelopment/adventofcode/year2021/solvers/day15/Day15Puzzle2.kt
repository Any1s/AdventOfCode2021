package de.mbdevelopment.adventofcode.year2021.solvers.day15

class Day15Puzzle2 : Day15Puzzle() {

    override fun getRiskMapFromTile(tile: List<List<Node>>): List<List<Node>> {
        val riskMap = MutableList(tile.size) { mutableListOf<Node>() }
        (0..4).forEach { horizontalTileNumber ->
            tile.forEachIndexed { tileRowIndex, tileRow ->
                riskMap[tileRowIndex].addAll(
                    tileRow.map { it.shiftBy(horizontalTileNumber, horizontalTileNumber * tile.first().size, 0) }
                )
            }
        }
        (1..4).forEach { verticalTileNumber ->
            (tile.indices).forEach { tileRowIndex ->
                riskMap += riskMap[tileRowIndex]
                    .map { it.shiftBy(verticalTileNumber, 0, verticalTileNumber * tile.size) }
                    .toMutableList()
            }
        }

        return riskMap
    }

    private fun Node.shiftBy(riskShift: Int, xShift: Int, yShift: Int): Node {
        val newRiskOfEntering = riskOfEntering + riskShift
        return copy(
            x = x + xShift,
            y = y + yShift,
            riskOfEntering = if (newRiskOfEntering > 9) newRiskOfEntering - 9 else newRiskOfEntering
        )
    }

}
