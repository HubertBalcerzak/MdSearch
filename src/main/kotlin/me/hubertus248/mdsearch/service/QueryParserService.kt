package me.hubertus248.mdsearch.service

import me.hubertus248.mdsearch.data.domain.Query
import org.springframework.stereotype.Service

/**
 * @author Hubertus
 *         Created 31.03.2018
 */
private val NON_ALPHANUMERIC_REGEX = "[^A-Za-z0-9 ]".toRegex()

@Service
class QueryParserService {
    fun parseQuery(query: String): Query =
            Query(query.replace(NON_ALPHANUMERIC_REGEX, "")
                    .split(" ")
                    .filter { it.isNotEmpty() }
            )

}