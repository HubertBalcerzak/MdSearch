/**
 * This class is generated by jOOQ
 */
package me.hubertus248.mdsearch.tables;

/**
 * This class is generated by jOOQ.
 */
@javax.annotation.Generated(value    = { "http://www.jooq.org", "3.4.1" },
                            comments = "This class is generated by jOOQ")
@java.lang.SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Indexes extends org.jooq.impl.TableImpl<me.hubertus248.mdsearch.tables.records.IndexesRecord> {

	private static final long serialVersionUID = -1598845339;

	/**
	 * The singleton instance of <code>mdsearch.indexes</code>
	 */
	public static final me.hubertus248.mdsearch.tables.Indexes INDEXES = new me.hubertus248.mdsearch.tables.Indexes();

	/**
	 * The class holding records for this type
	 */
	@Override
	public java.lang.Class<me.hubertus248.mdsearch.tables.records.IndexesRecord> getRecordType() {
		return me.hubertus248.mdsearch.tables.records.IndexesRecord.class;
	}

	/**
	 * The column <code>mdsearch.indexes.indexer_data</code>.
	 */
	public final org.jooq.TableField<me.hubertus248.mdsearch.tables.records.IndexesRecord, byte[]> INDEXER_DATA = createField("indexer_data", org.jooq.impl.SQLDataType.BLOB.length(255), this, "");

	/**
	 * The column <code>mdsearch.indexes.term</code>.
	 */
	public final org.jooq.TableField<me.hubertus248.mdsearch.tables.records.IndexesRecord, java.lang.String> TERM = createField("term", org.jooq.impl.SQLDataType.VARCHAR.length(128).nullable(false), this, "");

	/**
	 * Create a <code>mdsearch.indexes</code> table reference
	 */
	public Indexes() {
		this("indexes", null);
	}

	/**
	 * Create an aliased <code>mdsearch.indexes</code> table reference
	 */
	public Indexes(java.lang.String alias) {
		this(alias, me.hubertus248.mdsearch.tables.Indexes.INDEXES);
	}

	private Indexes(java.lang.String alias, org.jooq.Table<me.hubertus248.mdsearch.tables.records.IndexesRecord> aliased) {
		this(alias, aliased, null);
	}

	private Indexes(java.lang.String alias, org.jooq.Table<me.hubertus248.mdsearch.tables.records.IndexesRecord> aliased, org.jooq.Field<?>[] parameters) {
		super(alias, me.hubertus248.mdsearch.Mdsearch.MDSEARCH, aliased, parameters, "");
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.UniqueKey<me.hubertus248.mdsearch.tables.records.IndexesRecord> getPrimaryKey() {
		return me.hubertus248.mdsearch.Keys.KEY_INDEXES_PRIMARY;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.util.List<org.jooq.UniqueKey<me.hubertus248.mdsearch.tables.records.IndexesRecord>> getKeys() {
		return java.util.Arrays.<org.jooq.UniqueKey<me.hubertus248.mdsearch.tables.records.IndexesRecord>>asList(me.hubertus248.mdsearch.Keys.KEY_INDEXES_PRIMARY, me.hubertus248.mdsearch.Keys.KEY_INDEXES_INDEXES_TERM_UINDEX);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public me.hubertus248.mdsearch.tables.Indexes as(java.lang.String alias) {
		return new me.hubertus248.mdsearch.tables.Indexes(alias, this);
	}

	/**
	 * Rename this table
	 */
	public me.hubertus248.mdsearch.tables.Indexes rename(java.lang.String name) {
		return new me.hubertus248.mdsearch.tables.Indexes(name, null);
	}
}
