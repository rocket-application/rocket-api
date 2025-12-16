package ru.afanasyev.rocketapi.app

import ru.afanasyev.rocketapi.domain.Game
import ru.afanasyev.rocketapi.domain.GameStatus
import ru.afanasyev.rocketapi.domain.GameType

interface GameRepository {
    fun findAllGames(gameType: GameType, gameStatus: GameStatus): List<Game>
}