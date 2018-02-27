package me.hubertus248.mdsearch.service.indexer

/**
 * @author Hubertus
 *         Created 25.02.2018
 */
private val UNDERSCORED_HEADING_REGEX = "(.+)\\n[-=]+\\n".toRegex()
private val ALPHANUMERIC_REGEX = "[^A-Za-z0-9 ]".toRegex()
private val HEADING_REGEX = "[#]+\\s.+"

private val TABLE_PREFIX = "|"
private val HEADING_PREFIX = "#"

class DocumentCutter {

    val paragraphs = ArrayList<Paragraph>()
    fun cut(title: String, content: String) {
        addParagraph(title, WEIGHT_TITLE)
        content.apply {
            processUnderscoredHeadings(this)
            processParagraphs(this)
        }
        processUnderscoredHeadings(content)
    }

    private fun processUnderscoredHeadings(document: String): String {
        val results = UNDERSCORED_HEADING_REGEX.findAll(document)
        results.iterator().forEach {
            addParagraph(it.groupValues[1], WEIGHT_HEADING)
            document.replaceRange(it.range, "#")
        }
        return document
    }

    private fun processParagraphs(document: String) {
        val l = document.split("\n").map {
            val isHeading = it.startsWith(HEADING_PREFIX)
            val paragraphImportance = if (isHeading) WEIGHT_HEADING else WEIGHT_PARAGRAPH

            UnprocessedParagraph(it, paragraphImportance, isHeading, isHeading || it.startsWith(TABLE_PREFIX))
        }
//                .fold(ArrayList<Paragraph>(), { acc, paragraphLine -> if (paragraphLine.isNewParagraph || acc.size == 0||acc.last().) })
    }

    private fun addParagraph(text: String, weight: Float) {
        paragraphs.add(Paragraph(text.replace(ALPHANUMERIC_REGEX, "").toLowerCase(), weight))
    }
}

private class UnprocessedParagraph(
        var line: String,
        val importance: Float,
        val isHeading: Boolean = false,
        var isNewParagraph: Boolean = false
)