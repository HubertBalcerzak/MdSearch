package me.hubertus248.mdsearch.controller

import me.hubertus248.mdsearch.service.TermBank
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

/**
 * @author Hubertus
 *         Created 20.02.2018
 */
@RestController
class SearchController (val termBank: TermBank){

    @GetMapping("/search")
    fun search(
            @RequestParam(name = "query") query: String
    ) {
    }
}