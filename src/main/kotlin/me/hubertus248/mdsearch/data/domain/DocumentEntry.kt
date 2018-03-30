package me.hubertus248.mdsearch.data.domain

/**
 * @author Hubertus
 *         Created 02.03.2018
 */
class DocumentEntry(
        val documentId: Int,
        val rating: Float
) {
    fun writeSerialized(byteArray: ByteArray, writerIndex: Int) {
        writeInt(byteArray, writerIndex, documentId)
        writeInt(byteArray, writerIndex+4, rating.toBits())
    }



    private fun writeInt(array: ByteArray,writerIndex: Int, int: Int) {
        array[writerIndex] = (int and 0xFF00000 shr 24).toByte()
        array[writerIndex + 1] = (int and 0x00FF0000 shr 16).toByte()
        array[writerIndex + 2] = (int and 0x0000FF00 shr 8).toByte()
        array[writerIndex+3] = (int and 0x000000FF shr 0).toByte()
    }
}