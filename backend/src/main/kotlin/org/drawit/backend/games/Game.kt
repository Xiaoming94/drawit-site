package org.drawit.backend.games

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity(name = "games")
data class Game(@field: Id @field: GeneratedValue val id: Long? = null,
                val name: String = "",
                @Column(name="description", length = 512) val description: String = "")