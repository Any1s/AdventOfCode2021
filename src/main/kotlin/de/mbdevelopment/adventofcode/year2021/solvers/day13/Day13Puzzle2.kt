package de.mbdevelopment.adventofcode.year2021.solvers.day13

class Day13Puzzle2 : Day13Puzzle() {

    override fun solve(manual: Set<Dot>, foldInstructions: List<FoldInstruction>) =
        foldInstructions.fold(manual) { foldedManual, foldInstruction -> foldedManual.fold(foldInstruction) }
            .printable()

    private fun Set<Dot>.printable() =
        (0..maxOf { it.y }).map { y ->
            (0..maxOf { it.x }).map { x ->
                if (Dot(x, y) in this) '#' else '.'
            }.joinToString("")
        }.joinToString("\n")

}
