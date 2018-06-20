package org.drawit.backend.games

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
data class Game(@field: Id @field: GeneratedValue val Id: Long,
                val name: String = "")