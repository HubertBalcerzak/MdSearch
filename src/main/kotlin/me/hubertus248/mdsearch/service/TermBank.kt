package me.hubertus248.mdsearch.service

import me.hubertus248.mdsearch.data.domain.Term
import org.springframework.stereotype.Service
import java.util.concurrent.ConcurrentHashMap
import java.util.concurrent.PriorityBlockingQueue

/**
 * @author Hubertus
 *         Created 02.03.2018
 */
@Service
class TermBank() {

    private val terms: ConcurrentHashMap<String, Term> = ConcurrentHashMap()
    private val invalidationQueue = PriorityBlockingQueue<Term>()
//    operator fun get(termKey: String): Term {
//        val cachedValue = terms[termKey]
//    }
//
//    operator fun set(termKey: String, value: Term) {
//
//    }
}