package me.hubertus248.mdsearch.service.indexer

/**
 * @author Hubertus
 *         Created 21.02.2018
 */
//( {4,}.*|\x60{3}[\s\S]*\x60{3}|\x60.*\x60)
class DocumentParser {
    fun parseDocument(document: String): ParsedDocument? {
        DocumentCutter().run { cut("", document) }
        return null
    }
    private fun checkLine(line: String): Boolean = !line.contains("#{1,6}.*")
}