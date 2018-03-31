package me.hubertus248.mdsearch.controller

import me.hubertus248.mdsearch.data.domain.Query
import me.hubertus248.mdsearch.service.QueryParserService
import me.hubertus248.mdsearch.service.SearchService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

/**
 * @author Hubertus
 *         Created 20.02.2018
 */
@RestController
class SearchController(
        val queryParserService: QueryParserService,
        val searchService: SearchService) {

    @GetMapping("/search")
    fun search(
            @RequestParam(name = "query") query: String,
            @RequestParam(name = "nOfResults") n: Int
    ): List<String> {
        val parsedQuery: Query = queryParserService.parseQuery(query)
        return searchService.search(parsedQuery, n)
    }
}