package me.hubertus248.mdsearch

import me.hubertus248.mdsearch.data.domain.DocumentEntry
import me.hubertus248.mdsearch.data.domain.Term
import me.hubertus248.mdsearch.data.model.IndexModel

/**
 * @author Hubertus
 *         Created 07.03.2018
 */
class IndexEntryParser {
    fun parse(indexEntry: IndexModel): Term = Term(indexEntry.term,
            indexEntry.data.asIterable().chunked(8).map {
                DocumentEntry(
                        toInt(it.subList(0, 4)),
                        toInt(it.subList(4, 8))
                )
            })

    private fun toInt(bytes: List<Byte>) = bytes.fold(0, { acc, byte ->
        acc shl 8
        acc or byte.toInt()
    })
}