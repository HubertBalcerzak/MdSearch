package me.hubertus248.mdsearch.service.indexer

/**
 * @author Hubertus
 *         Created 02.03.2018
 */
class ParagraphIndexer() {
    val terms = HashMap<String, Float>()

    fun index(paragraph: Paragraph) {
        paragraph.content.split(" ").forEach { terms[it] = terms[it] ?: 0 + paragraph.importance }
    }
}