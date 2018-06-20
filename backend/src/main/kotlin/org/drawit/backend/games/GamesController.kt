package org.drawit.backend.games

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

@RestController

@RequestMapping("/json/games")

class GamesController(@Autowired private val gameReposiory : GameRepository ) {

    @RequestMapping(method = arrayOf(RequestMethod.GET))
    fun index(): List<Game> {
        return gameReposiory.findAll()
    }

}