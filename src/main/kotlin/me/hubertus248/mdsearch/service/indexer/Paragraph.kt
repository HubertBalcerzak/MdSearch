package me.hubertus248.mdsearch.service.indexer

/**
 * @author Hubertus
 *         Created 25.02.2018
 */
val WEIGHT_TITLE = 3f
val WEIGHT_PARAGRAPH = 1f
val WEIGHT_HEADING = 1.5f

data class Paragraph(
        val content: String,
        val importance: Float
)