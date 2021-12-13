package de.mbdevelopment.adventofcode.year2021.solvers.day13

class Day13Puzzle1 : Day13Puzzle() {

    override fun solve(manual: Set<Dot>, foldInstructions: List<FoldInstruction>): String {
        return manual.fold(foldInstructions.first()).size.toString()
    }

}
