package me.hubertus248.mdsearch.data.domain

/**
 * @author Hubertus
 *         Created 02.03.2018
 */
class Term(
        val text: String,
        val id: Long,
        val documentEntries: List<DocumentEntry> = ArrayList(),
        var lastAccess: Long = System.currentTimeMillis()
) : Comparable<Term> {
    override fun compareTo(other: Term): Int {
        return (other.lastAccess - lastAccess).toInt()
    }

    fun serialize(): ByteArray {
        val array = ByteArray(documentEntries.size * 16)
        documentEntries.forEachIndexed { i, documentEntry -> documentEntry.writeSerialized(array, i * 2) }
        return array
    }
}