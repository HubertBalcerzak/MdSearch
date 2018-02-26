package me.hubertus248.mdsearch.service.indexer

/**
 * @author Hubertus
 *         Created 21.02.2018
 */
data class ParsedDocument(
        val fragments: ArrayList<ParsedDocumentFragment>
)

data class ParsedDocumentFragment(
        val weight: Int,
        val distinctTerms: HashSet<String>
)