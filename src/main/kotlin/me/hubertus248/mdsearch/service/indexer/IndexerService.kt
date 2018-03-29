package me.hubertus248.mdsearch.service.indexer

import org.springframework.stereotype.Service

/**
 * @author Hubertus
 *         Created 20.02.2018
 */
@Service
class IndexerService {

    @Synchronized
    fun indexDocument(title: String, document: String) {

    }

    private fun clearPrevious(){

    }

//    private fun parseTerms(){
//        DocumentCutter()
//                .cut(title, document)
//                .forEach {
//                    it.content.split(" ").forEach{
//
//                    }
//                }
//    }
}