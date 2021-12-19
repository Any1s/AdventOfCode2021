package de.mbdevelopment.adventofcode.year2021.solvers.day19

import de.mbdevelopment.adventofcode.year2021.solvers.PuzzleSolver

class Day19Puzzle1 : PuzzleSolver {

    override fun solve(inputLines: Sequence<String>) = numberOfBeacons(inputLines).toString()

    private fun numberOfBeacons(scannerData: Sequence<String>): Int {
        val scanners = parseScanners(scannerData)
        val flippedScanners = scanners.map { flipAllAxis(it) }
        val flippedAndRotatedScanners = flippedScanners.map { scanner ->
            scanner +
                    scanner.map { rotateAroundX(it, 1) }.toSet() +
                    scanner.map { rotateAroundX(it, 2) }.toSet() +
                    scanner.map { rotateAroundX(it, 3) }.toSet() +
                    scanner.map { rotateAroundY(it, 1) }.toSet() +
                    scanner.map { rotateAroundY(it, 2) }.toSet() +
                    scanner.map { rotateAroundY(it, 3) }.toSet() +
                    scanner.map { rotateAroundZ(it, 1) }.toSet() +
                    scanner.map { rotateAroundZ(it, 2) }.toSet() +
                    scanner.map { rotateAroundZ(it, 3) }.toSet()
        }

        // TODO Some other day. I don't have time for this

        return 0
    }

    private fun parseScanners(scannerData: Sequence<String>): List<Set<Point>> {
        val scanners = mutableListOf<Set<Point>>()
        var currentScanner = mutableSetOf<Point>()
        scannerData
            .drop(1)
            .filter { it.isNotBlank() }
            .forEach { dataLine ->
                if (dataLine.startsWith("--- scanner")) {
                    scanners += currentScanner
                    currentScanner = mutableSetOf()
                } else {
                    val coordinates = dataLine.split(',').map { it.toInt() }
                    currentScanner += Point(coordinates[0], coordinates[1], coordinates[2])
                }
            }.also { scanners += currentScanner }

        return scanners
    }

    private fun flipAllAxis(points: Set<Point>) =
        setOf(points, flipX(points))
            .flatMap { setOf(it, flipY(it)) }
            .flatMap { setOf(it, flipZ(it)) }
            .toSet()

    private fun flipX(points: Set<Point>) = points.map { it * Point(-1, 1, 1) }.toSet()

    private fun flipY(points: Set<Point>) = points.map { it * Point(1, -1, 1) }.toSet()

    private fun flipZ(points: Set<Point>) = points.map { it * Point(1, 1, -1) }.toSet()

    private fun rotateAroundX(points: Set<Point>, times90Degrees: Int) = points.map {
        // x = x
        // y = y * cos(angle) - z * sin(angle)
        // z = y * sin(angle) + z * cos(angle)
        // Hardcoded, no time for math
        when (times90Degrees) {
            1 -> Point(it.x, it.z, it.y)
            2 -> Point(it.x, -1 * it.y, -1 * it.z)
            3 -> Point(it.x, -1 * it.z, -1 * it.y)
            else -> throw IllegalArgumentException("times90Degrees must be in {1, 2, 3}")
        }
    }.toSet()

    private fun rotateAroundY(points: Set<Point>, times90Degrees: Int) = points.map {
        // x = z * sin(angle) + x * cos(angle)
        // y = y
        // z = y * cos(angle) - x * sin(angle)
        // Hardcoded, no time for math
        when (times90Degrees) {
            1 -> Point(it.z, it.y, -1 * it.x)
            2 -> Point(-1 * it.x, it.y, -1 * it.y)
            3 -> Point(-1 * it.z, it.y, it.x)
            else -> throw IllegalArgumentException("times90Degrees must be in {1, 2, 3}")
        }
    }.toSet()

    private fun rotateAroundZ(points: Set<Point>, times90Degrees: Int) = points.map {
        // x = x * cos(angle) - y * sin(angle)
        // y = x * sin(angle) + y * cos(angle)
        // z = z
        // Hardcoded, no time for math
        when (times90Degrees) {
            1 -> Point(-1 * it.y, it.x, it.z)
            2 -> Point(-1 * it.x, -1 * it.y, it.z)
            3 -> Point(it.y, -1 * it.x, it.z)
            else -> throw IllegalArgumentException("times90Degrees must be in {1, 2, 3}")
        }
    }.toSet()

}

data class Point(val x: Int, val y: Int, val z: Int) {

    operator fun times(other: Point) = Point(x * other.x, y * other.y, z * other.z)

    operator fun plus(other: Point) = Point(x + other.x, y + other.y, z + other.z)
}
