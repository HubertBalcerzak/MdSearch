package me.hubertus248.mdsearch.data.repository

import me.hubertus248.mdsearch.tables.Documents.DOCUMENTS
import org.jooq.DSLContext
import org.springframework.stereotype.Service

/**
 * @author Hubertus
 *         Created 30.03.2018
 */
@Service
class DocumentsRepository(val ctx: DSLContext) {
    fun insertDocument(documentId: String): Int {
        ctx.insertInto(DOCUMENTS, DOCUMENTS.ORIGINALID)
                .values(documentId)
                .returning(DOCUMENTS.ID)
                .fetchOne()[DOCUMENTS.ID]
//        ctx.insertInto(DOCUMENTS, DOCUMENTS.ORIGINALID)
//                .values(documentId)
//                .execute()
        return 0
    }

    fun getOriginalId(id: Int): String =
            ctx.select(DOCUMENTS.ORIGINALID)
                    .from(DOCUMENTS)
                    .where(DOCUMENTS.ID.eq(id))
                    .fetchOne()[DOCUMENTS.ORIGINALID]
}