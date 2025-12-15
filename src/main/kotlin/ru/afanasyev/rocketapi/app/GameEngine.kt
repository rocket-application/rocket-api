package ru.afanasyev.rocketapi.app

import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component
import ru.afanasyev.rocketapi.domain.Game

@Component
class GameEngine(
    val gameRepository: GameRepository,
    val gameService: GameService
) {
    @Scheduled(fixedRate = 1000)
    fun runGame() {
        gameRepository.findAllRunningGames().stream()
            .forEach { moveGameObjects(it) }
    }

    private fun moveGameObjects(game: Game) {
        gameService.moveGameObjects(game.gameId)
        gameService.printGameObjects(game.gameId)
    }
}