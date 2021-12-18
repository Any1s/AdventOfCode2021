package de.mbdevelopment.adventofcode.year2021.solvers.day18

sealed class SnailfishNumber {
    class Pair(var left: SnailfishNumber, var right: SnailfishNumber) : SnailfishNumber() {
        override fun magnitude() = 3L * left.magnitude() + 2L * right.magnitude()
        override fun toString() = "[$left,$right]"
    }

    class Regular(var value: Long) : SnailfishNumber() {
        override fun magnitude() = value
        override fun toString() = value.toString()
    }

    abstract fun magnitude(): Long
}
