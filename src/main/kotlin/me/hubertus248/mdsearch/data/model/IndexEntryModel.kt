package me.hubertus248.mdsearch.data.model

import org.jetbrains.annotations.NotNull
import javax.persistence.*

/**
 * @author Hubertus
 *         Created 21.02.2018
 */
@Entity
@Table(name = "indexes")
class IndexEntryModel(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long,

        @NotNull
        @Column(nullable = false, length = 128)
        val term: String,

        val indexerData: ByteArray
)