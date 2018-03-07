package me.hubertus248.mdsearch.data.domain

/**
 * @author Hubertus
 *         Created 02.03.2018
 */
class Term(
        val text: String,
        val id: Long,
        val documentEntries: List<DocumentEntry> = ArrayList()
) : Comparable<Term> {
    var lastAccess = System.currentTimeMillis()

    override fun compareTo(other: Term): Int {
        return (other.lastAccess - lastAccess).toInt()
    }
}