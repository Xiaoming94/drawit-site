package org.drawit.backend.games

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.net.URI
import javax.servlet.http.HttpServletRequest

@RestController
@CrossOrigin(origins = ["http://localhost:8080", "http://localhost:8081"])
@RequestMapping("/json/games")

class GamesController(@Autowired private val repository: GameRepository) {

    @RequestMapping(method = [(RequestMethod.GET)])
    fun query(
            @RequestParam(value = "id", required = false) id: Long?,
            @RequestParam(value = "name", required = false) name: String?,
            @RequestParam(value = "players", required = false) players: Int?
    ): List<Game> {

        if (id != null) {
            return listOf(repository.findById(id).get())
        }

        if (name != null) {
            return repository.findByNameContainingIgnoringCase(name)
        }

        if (players != null) {
            return repository.findByPlayerCount(players)
        }

        return repository.findAll()
    }

    @PostMapping("/create")
    fun create(
            request: HttpServletRequest,
            @RequestBody body: Map<String, String>
    ): ResponseEntity<String> {

        val location = URI(request.requestURI)
        val responseHeader = HttpHeaders()
        responseHeader.location = location

        val gameName = body.get("name")
        val gameDescription = body.get("description")

        try {
            val game = Game(null, gameName!!, gameDescription!!)
            repository.save(game)
            responseHeader.set("Results", "ok")
            return ResponseEntity<String>("Post Results", responseHeader, HttpStatus.CREATED)
        } catch (nex: NullPointerException) {
            responseHeader.set("Results", "error: Cannot Be Null")
            return ResponseEntity<String>("Post Results", responseHeader, HttpStatus.EXPECTATION_FAILED)
        }


    }

}