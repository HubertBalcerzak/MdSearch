package me.hubertus248.mdsearch.service.indexer

/**
 * @author Hubertus
 *         Created 25.02.2018
 */
const val WEIGHT_TITLE = 30
const val WEIGHT_PARAGRAPH = 10
const val WEIGHT_HEADING = 15

class Paragraph(
        var content: String,
        val importance: Int
)