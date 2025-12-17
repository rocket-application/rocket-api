package ru.afanasyev.rocketapi.app.game

import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component
import ru.afanasyev.rocketapi.app.game.objects.GameObjectRepository
import ru.afanasyev.rocketapi.app.game.objects.GameObjectService
import ru.afanasyev.rocketapi.app.util.ObjectCollisionService
import ru.afanasyev.rocketapi.domain.Game
import ru.afanasyev.rocketapi.domain.GameObject
import ru.afanasyev.rocketapi.domain.GameStatus.RUNNING
import ru.afanasyev.rocketapi.domain.GameType.SINGLE
import ru.afanasyev.rocketapi.domain.Player

@Component
class GameEngine(
    val gameRepository: GameRepository,
    val gameObjectRepository: GameObjectRepository,
    val gameObjectService: GameObjectService,
    val gameStateService: GameStateService,
    val objectCollisionService: ObjectCollisionService,
) {
    @Scheduled(fixedRate = 1000)
    fun runGame() {
        gameRepository.findAllGames(gameType = SINGLE, gameStatus = RUNNING).stream()
            .forEach { tickForSinglePlayerGame(it) }
    }

    private fun tickForSinglePlayerGame(game: Game) {
        gameObjectService.moveGameObjects(game.gameId)
        gameObjectService.printGameObjects(game.gameId)
        val gameObjects = gameObjectRepository.getGameObjects(game.gameId)
        val player = gameObjects.getPlayer()
        val allObjectsExpectPlayer = gameObjects.getOtherObject(player)
        val collisionOccurred = checkPlayerCollisions(allObjectsExpectPlayer, player)
        if (collisionOccurred) {
            gameStateService.finishGame(game.gameId)
        }
    }

    private fun checkPlayerCollisions(allObjectsExpectPlayer: List<GameObject>, player: Player): Boolean {
        val collisionOccurred = allObjectsExpectPlayer
            .map { objectCollisionService.checkCollision(it, player) }
            .first { it }
        return collisionOccurred
    }
}