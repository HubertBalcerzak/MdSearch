package me.hubertus248.mdsearch.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

/**
 * @author Hubertus
 *         Created 20.02.2018
 */
@RestController
class IndexerController {

    @GetMapping("/")
    fun index(): String {
        return "kappa"
    }
}