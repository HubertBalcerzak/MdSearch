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
    fun cut(title: String, content: String) {
        addParagraph(title, WEIGHT_TITLE)
        content.apply {
            processUnderscoredHeadings(this)
            processParagraphs(this)
        }
        processUnderscoredHeadings(content)
        print("kappa")
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
        document
                .split("\n")
                .fold(ParagraphMerger(), { acc, line -> acc.addLine(line) })
                .paragraphs
                .forEach { addParagraph(it.content, it.weight) }
    }

    private fun addParagraph(text: String, weight: Float) {
        paragraphs.add(Paragraph(
                text
                        .replace(ALPHANUMERIC_REGEX, "")
                        .replace(MULTIPLE_SPACE_REGEX, " ")
                        .toLowerCase(),
                weight))
    }
}