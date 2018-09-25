package org.drawit.backend.games

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity(name = "games")
data class Game(@field: Id @field: GeneratedValue val id: Long? = null,
                val name: String = "",
                @Column(name="description", length = 512) val description: String = "",
                @Column(name="rule", length = 256) val rules: String = "",
                @Column(name="player_min") val player_min: Integer = Integer(1),
                @Column(name="player_max") val player_max: Integer = Integer(1),
                @Column(name="time") val playTime: String = "",
                @Column(name="status") val status: String = "",
                @Column(name="condition") val condition: String = "Complete")