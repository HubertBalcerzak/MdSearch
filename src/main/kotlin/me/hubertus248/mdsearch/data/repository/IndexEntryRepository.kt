package me.hubertus248.mdsearch.data.repository

import me.hubertus248.mdsearch.data.model.IndexEntryModel
import org.springframework.data.jpa.repository.JpaRepository

/**
 * @author Hubertus
 *         Created 21.02.2018
 */
interface IndexEntryRepository : JpaRepository<IndexEntryModel, Long> {

}