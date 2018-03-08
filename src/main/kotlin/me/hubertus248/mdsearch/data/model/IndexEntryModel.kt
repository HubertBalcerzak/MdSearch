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
        var id: Long? = null,

        @NotNull
        @Column(nullable = false, length = 128)
        var term: String? = null,

        var indexerData: ByteArray? = null
)