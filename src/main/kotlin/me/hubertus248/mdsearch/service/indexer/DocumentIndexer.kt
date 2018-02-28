package me.hubertus248.mdsearch.service.indexer

/**
 * @author Hubertus
 *         Created 21.02.2018
 */
class DocumentIndexer {
    fun parseDocument(document: String): ParsedDocument? {
        DocumentCutter().run { cut("", document) }
        return null
    }
    private fun checkLine(line: String): Boolean = !line.contains("#{1,6}.*")
}