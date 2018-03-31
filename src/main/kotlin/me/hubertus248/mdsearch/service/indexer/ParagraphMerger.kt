package me.hubertus248.mdsearch.service.indexer

import me.hubertus248.mdsearch.service.indexer.State.*

/**
 * @author Hubertus
 *         Created 28.02.2018
 */
private val HEADING_REGEX = "[#]+\\s.+".toRegex()
private val TABLE_REGEX = "[|].+[|]".toRegex()

private enum class State {
    BEGINNING,
    IN_PARAGRAPH,
    SEEN_PARAGRAPH_END
}

class ParagraphMerger {
    val paragraphs: ArrayList<UnprocessedParagraph> = ArrayList()
    private var state: State = BEGINNING

    fun addLine(line: String): ParagraphMerger {
        when {
            line matches HEADING_REGEX -> processAsHeading(line)
            line matches TABLE_REGEX -> processAsTable(line)
            else -> processAsParagraphLine(line)
        }
        return this
    }

    private fun processAsHeading(line: String) {
        state = SEEN_PARAGRAPH_END
        paragraphs.add(UnprocessedParagraph(line, WEIGHT_HEADING))
    }

    private fun processAsTable(line: String) {
        state = SEEN_PARAGRAPH_END
        line.split('|').forEach { paragraphs.add(UnprocessedParagraph(it, WEIGHT_PARAGRAPH)) }
    }

    private fun processAsParagraphLine(line: String) {
        when (state) {
            BEGINNING -> paragraphs.add(UnprocessedParagraph(line, WEIGHT_PARAGRAPH))
            SEEN_PARAGRAPH_END -> paragraphs.add(UnprocessedParagraph(line, WEIGHT_PARAGRAPH))
            IN_PARAGRAPH -> paragraphs.last().addLine(line)
        }
        state = IN_PARAGRAPH
    }
}

class UnprocessedParagraph(
        var content: String,
        val weight: Int
) {
    fun addLine(line: String) {
        content += " " + line
    }
}