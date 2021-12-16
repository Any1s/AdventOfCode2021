package de.mbdevelopment.adventofcode.year2021.solvers.day16

sealed class Packet(open val version: Int, open val subPackets: List<Packet> = emptyList()) {

    companion object {
        const val LITERAL_VALUE = 4;
    }

    abstract fun evaluate(): Long

    data class LiteralValue(override val version: Int, val value: Long) : Packet(version) {
        override fun evaluate() = value
    }

    data class Sum(override val version: Int, override val subPackets: List<Packet>) : Packet(version, subPackets) {
        override fun evaluate() = subPackets.sumOf { it.evaluate() }
    }

    data class Product(override val version: Int, override val subPackets: List<Packet>) : Packet(version, subPackets) {
        override fun evaluate() = subPackets.map { it.evaluate() }.fold(1L, Long::times)
    }

    data class Minimum(override val version: Int, override val subPackets: List<Packet>) : Packet(version, subPackets) {
        override fun evaluate() = subPackets.minOf { it.evaluate() }
    }

    data class Maximum(override val version: Int, override val subPackets: List<Packet>) : Packet(version, subPackets) {
        override fun evaluate() = subPackets.maxOf { it.evaluate() }
    }

    data class GreaterThan(override val version: Int, override val subPackets: List<Packet>) :
        Packet(version, subPackets) {
        override fun evaluate() = if (subPackets[0].evaluate() > subPackets[1].evaluate()) 1L else 0L
    }

    data class LessThan(override val version: Int, override val subPackets: List<Packet>) :
        Packet(version, subPackets) {
        override fun evaluate() = if (subPackets[0].evaluate() < subPackets[1].evaluate()) 1L else 0L
    }

    data class EqualTo(override val version: Int, override val subPackets: List<Packet>) : Packet(version, subPackets) {
        override fun evaluate() = if (subPackets[0].evaluate() == subPackets[1].evaluate()) 1L else 0L
    }

    fun versionSum(): Int = version + subPackets.sumOf { it.versionSum() }
}
