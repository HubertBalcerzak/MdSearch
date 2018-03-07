package me.hubertus248.mdsearch

import me.hubertus248.mdsearch.data.domain.DocumentEntry
import me.hubertus248.mdsearch.data.domain.Term
import me.hubertus248.mdsearch.data.model.IndexEntryModel

/**
 * @author Hubertus
 *         Created 07.03.2018
 */
class IndexEntryParser {
    fun parse(indexEntry: IndexEntryModel): Term = Term(indexEntry.term, indexEntry.id,
            indexEntry.indexerData.asIterable().chunked(8).map {
                DocumentEntry(
                        toInt(it.subList(0, 3)),
                        Float.fromBits(toInt(it.subList(4, 7)))
                )
            })

    private fun toInt(bytes: List<Byte>) = bytes.fold(0, { acc, byte ->
        acc shl 8
        acc or byte.toInt()
    })
}