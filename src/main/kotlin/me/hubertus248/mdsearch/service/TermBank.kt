package me.hubertus248.mdsearch.service

import me.hubertus248.mdsearch.IndexEntryParser
import me.hubertus248.mdsearch.data.domain.Term
import me.hubertus248.mdsearch.data.model.IndexEntryModel
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
    private val MAX_CACHED_ENTRIES = 1000

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
                terms[term.text] = term
                invalidationQueue.add(term)
                invalidationCheck()
                term
            }
        } else {
            cachedValue.lastAccess = System.currentTimeMillis()
            cachedValue
        }
    }

    operator fun set(termKey: String, value: Term) {
        val model = IndexEntryModel()
        model.term = termKey
        model.indexerData = value.serialize()
        indexEntryRepository.save(model)
        if (terms.containsKey(termKey)) {
            terms[termKey]?.lastAccess = Long.MIN_VALUE
            terms.remove(termKey)
        }
    }

    private var getCounter: Int = 0

    @Synchronized
    private fun invalidationCheck() {
        getCounter++
        if (getCounter > INVALIDATION_CHECK_INTERVAL) {
            getCounter = 0
            while (invalidationQueue.size > MAX_CACHED_ENTRIES)
                terms.remove(invalidationQueue.poll()?.text)
        }
    }
}