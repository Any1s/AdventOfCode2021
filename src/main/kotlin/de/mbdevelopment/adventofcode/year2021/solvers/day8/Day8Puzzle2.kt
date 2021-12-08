package de.mbdevelopment.adventofcode.year2021.solvers.day8

import de.mbdevelopment.adventofcode.year2021.solvers.PuzzleSolver

class Day8Puzzle2 : PuzzleSolver {

    override fun solve(inputLines: Sequence<String>) = sumOfDecodedNumbers(inputLines).toString()

    private fun sumOfDecodedNumbers(digitSignalsAndReading: Sequence<String>) = digitSignalsAndReading
        .filter { it.isNotBlank() }
        .map { it.split(" | ") }
        .map { decodeNumberByElimination(it[0].split(' '), it[1].split(' ')) }
        .sum()

    private fun decodeNumberByElimination(uniquePatterns: List<String>, digits: List<String>): Int {
        val number1 = uniquePatterns.single { it.length == 2 }.toSet()
        val number4 = uniquePatterns.single { it.length == 4 }.toSet()
        val number7 = uniquePatterns.single { it.length == 3 }.toSet()
        val number8 = uniquePatterns.single { it.length == 7 }.toSet()

        val unknownNumbersOfLength5 = uniquePatterns.filter { it.length == 5 }.map { it.toSet() }.toMutableSet()
        val unknownNumbersOfLength6 = uniquePatterns.filter { it.length == 6 }.map { it.toSet() }.toMutableSet()

        val segmentA = (number7 - number1).single()
        val segmentG = unknownNumbersOfLength5.reduce(Collection<Char>::intersect)
            .intersect(unknownNumbersOfLength6.reduce(Collection<Char>::intersect))
            .minus(number4)
            .minus(number7)
            .single()
        val segmentE = (number8 - segmentG - number4 - number7).single()
        val number2 = unknownNumbersOfLength5.single { it.containsAll(listOf(segmentA, segmentE, segmentG)) }
        unknownNumbersOfLength5 -= number2

        val segmentF = unknownNumbersOfLength5.reduce(Collection<Char>::intersect).minus(number2).single()
        val segmentB = unknownNumbersOfLength5.reduce { a, b -> (a - b).union(b - a) }.minus(number2).single()
        val number5 = unknownNumbersOfLength5.single { it.contains(segmentB) }
        unknownNumbersOfLength5 -= number5
        val number3 = unknownNumbersOfLength5.single()

        val segmentC = (number7 - segmentA - segmentF).single()
        val allPossibleCorrectSegments = setOf('a', 'b', 'c', 'd', 'e', 'f', 'g')
        val segmentD = allPossibleCorrectSegments.asSequence()
            .minus(segmentA).minus(segmentB).minus(segmentC).minus(segmentE).minus(segmentF).minus(segmentG)
            .single()
        val number0 = unknownNumbersOfLength6.single { !it.contains(segmentD) }
        unknownNumbersOfLength6 -= number0
        val number6 = unknownNumbersOfLength6.single { !it.contains(segmentC) }
        unknownNumbersOfLength6 -= number6
        val number9 = unknownNumbersOfLength6.single()

        val decoder = mapOf(
            number0 to '0',
            number1 to '1',
            number2 to '2',
            number3 to '3',
            number4 to '4',
            number5 to '5',
            number6 to '6',
            number7 to '7',
            number8 to '8',
            number9 to '9',
        )

        return digits.map { it.toSet() }.mapNotNull { decoder[it] }.joinToString("").toInt()
    }
}