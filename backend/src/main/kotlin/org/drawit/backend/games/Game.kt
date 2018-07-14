package org.drawit.backend.games

import javax.persistence.*

@Entity(name = "games")
@Table(name = "games")
data class Game(@field: Id @field: GeneratedValue val id: Long? = null,
                val name: String = "",
                @Column(name = "description", length = 512) val description: String = "",
                @Column(name = "player_min") val playerMin: Int? = 0,
                @Column(name = "player_max") val playerMax: Int? = 0)