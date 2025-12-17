package ru.afanasyev.rocketapi.adapter

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import ru.afanasyev.rocketapi.app.game.`object`.GameObjectService
import ru.afanasyev.rocketapi.app.game.GameState
import ru.afanasyev.rocketapi.app.game.GameStateService
import ru.afanasyev.rocketapi.domain.Game
import ru.afanasyev.rocketapi.domain.ObjectPosition

@RestController
@RequestMapping("/api/v1/games")
class GameController(
    val gameStateService: GameStateService,
    val gameObjectService: GameObjectService,
) {
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun start(): Game {
        return gameStateService.startGame()
    }

    @PutMapping("/{gameId}/pause")
    fun pause(@PathVariable gameId: String) {
        gameStateService.pauseGame(gameId)
    }

    @PutMapping("/{gameId}/resume")
    fun resume(@PathVariable gameId: String) {
        gameStateService.resumeGame(gameId)
    }

    @PutMapping("/{gameId}/change-vector")
    fun changePlayerVector(
        @PathVariable gameId: String,
        @RequestBody newVector: ObjectPosition,
        @RequestParam playerId: String,
    ) {
        return gameObjectService.changePlayerVector(gameId, newVector, playerId)
    }

    @GetMapping("/{gameId}")
    fun getState(@PathVariable gameId: String): GameState {
        return gameObjectService.gatGameState(gameId)
    }
}
