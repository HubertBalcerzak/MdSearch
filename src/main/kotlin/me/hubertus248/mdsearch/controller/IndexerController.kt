package me.hubertus248.mdsearch.controller

import me.hubertus248.mdsearch.service.indexer.DocumentIndexer
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

/**
 * @author Hubertus
 *         Created 20.02.2018
 */
@RestController
class IndexerController {

    @PostMapping("/index")
    fun index(
            @RequestParam(name = "document") document: String) {
        DocumentIndexer().run { parseDocument(document) }
    }
}