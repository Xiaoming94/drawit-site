package org.drawit.backend.games

import org.springframework.data.jpa.repository.JpaRepository

interface GameRepository : JpaRepository<Game,Long> {

    fun findByNameContainingIgnoringCase(name: String)

}