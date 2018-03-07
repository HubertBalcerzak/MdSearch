package me.hubertus248.mdsearch.service

import me.hubertus248.mdsearch.IndexEntryParser
import me.hubertus248.mdsearch.data.domain.Term
import me.hubertus248.mdsearch.data.repository.IndexEntryRepository
import org.springframework.stereotype.Service
import java.util.concurrent.ConcurrentHashMap
import java.util.concurrent.PriorityBlockingQueue

/**
 * @author Hubertus
 *         Created 02.03.2018
 */
@Service
class TermBank(val indexEntryRepository: IndexEntryRepository) {

    private val INVALIDATION_CHECK_INTERVAL = 100

    private val entryParser = IndexEntryParser()

    private val terms: ConcurrentHashMap<String, Term> = ConcurrentHashMap()
    private val invalidationQueue = PriorityBlockingQueue<Term>()
    operator fun get(termKey: String): Term? {
        val cachedValue = terms[termKey]
        return if (cachedValue == null) {
            val entryModel = indexEntryRepository.findOneByTerm(termKey)
            if (entryModel == null) {
                null
            } else {
                val term = entryParser.parse(entryModel)
                invalidationCheck()
                term
            }
        } else {
            cachedValue.lastAccess = System.currentTimeMillis()
            cachedValue
        }
    }
//
//    operator fun set(termKey: String, value: Term) {
//
//    }

    private var getCounter: Int = 0

    @Synchronized
    private fun invalidationCheck() {
        getCounter++

    }
}