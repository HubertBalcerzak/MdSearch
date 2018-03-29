package me.hubertus248.mdsearch.data.model

/**
 * @author Hubertus
 *         Created 21.03.2018
 */
open class IndexModel(
        val id: Long,
        val term: String,
        val data: ByteArray
){}