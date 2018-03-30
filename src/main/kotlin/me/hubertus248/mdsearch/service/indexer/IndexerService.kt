package me.hubertus248.mdsearch.service.indexer

import me.hubertus248.mdsearch.data.domain.DocumentEntry
import me.hubertus248.mdsearch.data.domain.Term
import me.hubertus248.mdsearch.data.repository.DocumentsRepository
import me.hubertus248.mdsearch.service.TermBank
import org.springframework.stereotype.Service

/**
 * @author Hubertus
 *         Created 20.02.2018
 */
@Service
class IndexerService(
        val termBank: TermBank,
        val documentsRepository: DocumentsRepository) {

    @Synchronized
    fun indexDocument(documentId: String, title: String, document: String) {

        val localDocumentId = documentsRepository.insertDocument(documentId)

        val paragraphIndexer = ParagraphIndexer()
        DocumentCutter().cut(title, document).forEach { paragraphIndexer.index(it) }
        paragraphIndexer.terms.entries.forEach { updateTerm(it.key, it.value, localDocumentId) }
    }

    private fun updateTerm(termKey: String, rating: Float, localDocumentId: Int) {
        val oldTerm: Term? = termBank[termKey]
        val documentEntries = ArrayList<DocumentEntry>()
        if (oldTerm != null) documentEntries.addAll(oldTerm.documentEntries)
        documentEntries.add(DocumentEntry(localDocumentId, rating))
        termBank[termKey] = Term(termKey, documentEntries, Long.MIN_VALUE)
    }

}