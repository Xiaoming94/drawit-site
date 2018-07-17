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

        val sb = StringBuilder()
        sb.append("SELECT g FROM " + Game::class.java.name + " g WHERE ")
        if (id != null)
            sb.append("g.id = $id AND ")
        if (name != null)
            sb.append("g.name LIKE '$name' AND ")
        if (players != null)
            sb.append("g.playerMin <= $players AND g.playerMax >= $players AND ")

        val query = sb.removeSuffix(" AND ").toString()

        return repository.stringQuery(query)

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