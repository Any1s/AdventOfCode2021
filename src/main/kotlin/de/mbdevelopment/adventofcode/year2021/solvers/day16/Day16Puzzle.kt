package de.mbdevelopment.adventofcode.year2021.solvers.day16

import de.mbdevelopment.adventofcode.year2021.solvers.PuzzleSolver

abstract class Day16Puzzle : PuzzleSolver {

    companion object {
        private val hexToBits = mapOf(
            '0' to "0000",
            '1' to "0001",
            '2' to "0010",
            '3' to "0011",
            '4' to "0100",
            '5' to "0101",
            '6' to "0110",
            '7' to "0111",
            '8' to "1000",
            '9' to "1001",
            'A' to "1010",
            'B' to "1011",
            'C' to "1100",
            'D' to "1101",
            'E' to "1110",
            'F' to "1111",
        ).mapValues { it.value.toList() }
    }

    final override fun solve(inputLines: Sequence<String>) = solve(parseTransmissionHex(inputLines.first())).toString()

    abstract fun solve(outerPacket: Packet): Long

    private fun parseTransmissionHex(transmissionHex: String) = transmissionHex
        .flatMap { hexToBits[it] ?: emptyList() }
        .asReversed()
        .let { ArrayDeque(it) }
        .let { parsePacket(it) }

    private fun parsePacket(bits: ArrayDeque<Char>): Packet {
        val version = bits.nNextBitsToInt(3)
        val typeId = bits.nNextBitsToInt(3)

        return if (typeId == Packet.LITERAL_VALUE) {
            Packet.LiteralValue(version, parseLiteralValue(bits))
        } else {
            parseOperator(version, typeId, bits)
        }
    }

    private fun parseLiteralValue(bits: ArrayDeque<Char>): Long {
        var value = ""
        var lastBlock = false;
        while (!lastBlock) {
            lastBlock = bits.removeLast() == '0'
            value += bits.nNextBits(4)
        }
        return value.toLong(2)
    }

    private fun parseOperator(version: Int, typeId: Int, bits: ArrayDeque<Char>): Packet {
        val lengthTypeId = bits.removeLast()

        val subPackets = if (lengthTypeId == '0') {
            val totalSubPacketLength = bits.nNextBitsToInt(15)
            val subPacketBits = ArrayDeque<Char>()
            repeat(totalSubPacketLength) { subPacketBits.addFirst(bits.removeLast()) }
            val subPackets = mutableListOf<Packet>()
            while (subPacketBits.isNotEmpty()) {
                subPackets += parsePacket(subPacketBits)
            }
            subPackets
        } else {
            val numberOfSubPackets = bits.nNextBitsToInt(11)
            val subPackets = mutableListOf<Packet>()
            while (subPackets.size < numberOfSubPackets) {
                subPackets += parsePacket(bits)
            }
            subPackets
        }

        return toOperator(version, typeId, subPackets)
    }

    private fun toOperator(version: Int, typeId: Int, subPackets: List<Packet>): Packet = when (typeId) {
        0 -> Packet.Sum(version, subPackets)
        1 -> Packet.Product(version, subPackets)
        2 -> Packet.Minimum(version, subPackets)
        3 -> Packet.Maximum(version, subPackets)
        5 -> Packet.GreaterThan(version, subPackets)
        6 -> Packet.LessThan(version, subPackets)
        7 -> Packet.EqualTo(version, subPackets)
        else -> throw IllegalArgumentException("Unknown operator typeId: $typeId")
    }

    private fun ArrayDeque<Char>.nNextBitsToInt(n: Int) = nNextBits(n).toInt(2)

    private fun ArrayDeque<Char>.nNextBits(n: Int) =
        (0 until n).fold("") { binary, _ -> binary + removeLast() }

}
