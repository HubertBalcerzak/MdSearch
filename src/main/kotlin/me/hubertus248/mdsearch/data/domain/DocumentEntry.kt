package me.hubertus248.mdsearch.data.domain

/**
 * @author Hubertus
 *         Created 02.03.2018
 */
class DocumentEntry(
        val documentId: Int,
        val rating: Float
) {
    fun writeSerialized(byteArray: ByteArray, writerIndex: Int): Nothing = TODO()
}