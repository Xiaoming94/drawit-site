package org.drawit.backend.games

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.net.URI
import javax.servlet.http.HttpServletRequest

import kotlin.text.StringBuilder

@RestController
@CrossOrigin(origins = ["http://localhost:8080", "http://localhost:8081"])
@RequestMapping("/json/games")

class GamesController(@Autowired private val gameRepository: GameRepository) {

    @RequestMapping(method = [(RequestMethod.GET)])
    fun query(
            @RequestParam(value = "id", required = false) id: String,
            @RequestParam(value = "name", required = false) name: String
    ): List<Game> {

        /* TODO basic implementation, does not allow combining searches
        ideally avoid a "else if" tree, perhaps easiest to ignore repository
        and make the sql query
        */
        if (id != null) {
            return gameRepository.findById(id)
        }

        if (name != null) {
            return gameRepository.findByNameContainingIgnoringCase(name)
        }

        // other version, might be slow, doing unions between the lists

        val list = mutableListOf<Game>()

        if (name != null) {
            val filterList = gameRepository.findByNameContainingIgnoringCase(id) as List<Game>
            list.filter { game -> filterList.contains(game) }
        }

        /*...*/

        // third variant, build custom query

        val sb = StringBuilder()

        // TODO use string constants
        sb.append("SELECT * FROM games WHERE")
        if (name != null)
            sb.append("name LIKE $name AND")
        /*... add more if-clauses for each attribute ...*/
        sb.removeSuffix(" AND")
        return gameRepository.stringQuery(sb.toString())

        return gameRepository.findAll()
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
            gameRepository.save(game)
            responseHeader.set("Results", "ok")
            return ResponseEntity<String>("Post Results", responseHeader, HttpStatus.CREATED)
        } catch (nex: NullPointerException) {
            responseHeader.set("Results", "error: Cannot Be Null")
            return ResponseEntity<String>("Post Results", responseHeader, HttpStatus.EXPECTATION_FAILED)
        }


    }

}