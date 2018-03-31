package me.hubertus248.mdsearch.service

import me.hubertus248.mdsearch.data.domain.Query
import me.hubertus248.mdsearch.data.repository.DocumentsRepository
import org.springframework.stereotype.Service
import java.util.*

/**
 * @author Hubertus
 *         Created 31.03.2018
 */
@Service
class SearchService(val termBank: TermBank, val documentsRepository: DocumentsRepository) {
    fun search(query: Query, numberOfResults: Int): List<String> {
        val entriesMap: HashMap<Int, SearchEntry> = HashMap()
        query.queryElements.forEach {
            termBank[it]?.documentEntries?.forEach {
                entriesMap[it.documentId] = (entriesMap[it.documentId]?.addRating(it.rating)
                        ?: SearchEntry(it.documentId, it.rating))
            }
        }
        val entries: List<SearchEntry> = entriesMap.values.toList()
        Collections.sort(entries)

        return if (numberOfResults > entries.size) entries.map {
            documentsRepository.getOriginalId(it.id)
        }
        else entries.subList(0, numberOfResults).map {
            documentsRepository.getOriginalId(it.id)
        }
    }
}

class SearchEntry(val id: Int, var rating: Int) : Comparable<SearchEntry> {
    override fun compareTo(other: SearchEntry): Int = rating - other.rating
    fun addRating(value: Int): SearchEntry {
        this.rating += value
        return this
    }
}