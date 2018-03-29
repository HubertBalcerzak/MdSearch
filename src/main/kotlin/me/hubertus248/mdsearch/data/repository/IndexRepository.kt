package me.hubertus248.mdsearch.data.repository

import me.hubertus248.mdsearch.data.model.IndexModel
import me.hubertus248.mdsearch.tables.Indexes.INDEXES
import me.hubertus248.mdsearch.tables.records.IndexesRecord
import org.jooq.DSLContext
import org.springframework.stereotype.Component

/**
 * @author Hubertus
 *         Created 10.03.2018
 */
@Component
class IndexRepository(val ctx: DSLContext) {
    fun getIndexByTerm(term: String): IndexModel? {
        return ctx
                .select(INDEXES.TERM, INDEXES.INDEXER_DATA)
                .from(INDEXES)
                .where(INDEXES.TERM.eq(term))
                .fetchOneInto(IndexModel::class.java)
    }

    fun storeTerm(term: String, data: ByteArray) {
        val record: IndexesRecord = ctx.newRecord(INDEXES)
        record.term = term
        record.indexerData = data
        record.store()
    }
}