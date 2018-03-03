package me.hubertus248.mdsearch.service.indexer

import org.springframework.stereotype.Service

/**
 * @author Hubertus
 *         Created 20.02.2018
 */
@Service
class IndexerService {
    fun parseDocument(title: String, document: String) {
        DocumentCutter()
                .cut(title, document)
                .forEach {

                }
    }
}