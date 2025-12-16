package ru.afanasyev.rocketapi.domain

import ru.afanasyev.rocketapi.domain.GameStatus.*

data class Game(
    val gameId: String,
    val type: GameType,
    var gameStatus: GameStatus = INITIALIZED
)

enum class GameType {
    SINGLE
}

enum class GameStatus {
    INITIALIZED, RUNNING, PAUSED, FINISHED
}
