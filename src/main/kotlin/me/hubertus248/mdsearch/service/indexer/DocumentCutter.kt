package me.hubertus248.mdsearch.service.indexer

/**
 * @author Hubertus
 *         Created 25.02.2018
 */
private val UNDERSCORED_HEADING_REGEX = "(.+)\\n[-=]+\\n".toRegex()
private val ALPHANUMERIC_REGEX = "[^A-Za-z0-9 ]".toRegex()
private val MULTIPLE_SPACE_REGEX = "[ ][ ]+".toRegex()

class DocumentCutter {

    private val paragraphs = ArrayList<Paragraph>()
    fun cut(title: String, content: String): ArrayList<Paragraph> {
        addParagraph(title, WEIGHT_TITLE)
        val halfProcessedContent = processUnderscoredHeadings(content)
        processParagraphs(halfProcessedContent)
        return paragraphs
    }

    private fun processUnderscoredHeadings(document: String): String {
        val results = UNDERSCORED_HEADING_REGEX.findAll(document)
        return results.toList().foldRight(document, { result, acc ->
            addParagraph(result.groupValues[1], WEIGHT_HEADING)
            acc.replaceRange(result.range, "#")
        })
    }

    private fun processParagraphs(document: String) {
        document
                .split("\n")
                .fold(ParagraphMerger(), { acc, line -> acc.addLine(line) })
                .paragraphs
                .forEach { addParagraph(it.content, it.weight) }
    }

    private fun addParagraph(text: String, weight: Int) {
        val escapedText = text
                .replace(ALPHANUMERIC_REGEX, "")
                .replace(MULTIPLE_SPACE_REGEX, " ")
                .toLowerCase()
        if (escapedText.isNotBlank())
            paragraphs.add(Paragraph(escapedText, weight))
    }
}