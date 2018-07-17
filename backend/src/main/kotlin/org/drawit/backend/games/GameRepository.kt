package org.drawit.backend.games

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import java.util.*

interface GameRepository : JpaRepository<Game, Long>, CustomGameRepository {


    fun findByIdOrNameContainingIgnoringCase(id: Long, name: String): List<Game>

    fun findByNameContainingIgnoringCase(name: String): List<Game>

    @Query("select g from #{#entityName} g where g.playerMin <= ?1")
    fun findByPlayerCountGEQThan(min: Int): List<Game>

    @Query("select g from #{#entityName} g where g.playerMin >= ?1")
    fun findByPlayerCountLEQThan(max: Int): List<Game>

    /**
     * Queries for games that could be played by count players (i.e. min <= count <= max)
     */
    @Query("select g from #{#entityName} g where g.playerMin <= ?1 and g.playerMax >= ?1")
    fun findByPlayerCount(count: Int): List<Game>

}