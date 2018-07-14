package org.drawit.backend.games

import javax.persistence.EntityManager
import javax.persistence.PersistenceContext

interface CustomGameRepository {
    fun stringQuery(query: String): List<Game>
}

class CustomGameRepositoryImpl : CustomGameRepository {

    @PersistenceContext
    val em: EntityManager

    override fun stringQuery(query: String): List<Game> {
        val q = em.createQuery(query)
        return q.resultList as List<Game>
    }
}