package de.mbdevelopment.adventofcode.year2021.solvers.day18

class Day18Puzzle2 : Day18Puzzle() {

    override fun homework(snailfishNumbers: Sequence<String>): Long {
        val unparsedNumbers = snailfishNumbers
            .filter { it.isNotBlank() }
            .map { it.toList() }
            .toList()

        return unparsedNumbers.flatMapIndexed { indexA, a ->
            unparsedNumbers.flatMapIndexed { indexB, b ->
                if (indexA != indexB) {
                    // Addition happens in-place, so we need fresh instances for each one. Damn mutable state...
                    listOf(parse(ArrayDeque(a)) to parse(ArrayDeque(b)), parse(ArrayDeque(b)) to parse(ArrayDeque(a)))
                } else emptyList()
            }
        }.asSequence()
            .map { it.first + it.second }
            .map { it.magnitude() }
            .maxOf { it }
    }

}
