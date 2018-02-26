package me.hubertus248.mdsearch.service.indexer

/**
 * @author Hubertus
 *         Created 25.02.2018
 */
class DocumentCutter() {
    val paragraphs = ArrayList<Paragraph>()
    fun cut(title: String, content: String) {
        paragraphs.add(Paragraph(escape(title), WEIGHT_TITLE))
        processUnderscoredHeadings(content)
    }

    private fun processUnderscoredHeadings(document: String): String {
        val results = Regex("(.+)\\n[-=]+\\n").findAll(document)
        results.iterator().forEach {
            paragraphs.add(Paragraph(escape(it.groupValues[1]), WEIGHT_HEADING))
            document.removeRange(it.range)
        }
        return document
    }

    private fun escape(text: String): String {
        return text
    }
}