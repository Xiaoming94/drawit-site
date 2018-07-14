package org.drawit.backend.games

import org.springframework.data.jpa.repository.JpaRepository

interface GameRepository : JpaRepository<Game, Long>, CustomGameRepository{


    fun findByIdOrNameContainingIgnoringCase(id: Long, name: String): List<Game>

    fun findByNameContainingIgnoringCase(name: String)

}