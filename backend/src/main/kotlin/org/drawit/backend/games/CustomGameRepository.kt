package org.drawit.backend.games

import javax.persistence.EntityManager
import javax.persistence.PersistenceContext

interface CustomGameRepository {
    fun stringQuery(query: String): List<Game>
}

class CustomGameRepositoryImpl : CustomGameRepository {

    @PersistenceContext
    var em: EntityManager? = null

    override fun stringQuery(query: String): List<Game> {
//        val q = em!!.createQuery(query)
//        return q.resultList as List<Game>
//

        return em!!.createQuery(query).resultList as List<Game>
    }
}