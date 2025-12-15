package ru.afanasyev.rocketapi.domain

import ru.afanasyev.rocketapi.domain.GameState.*

data class Game(
    val gameId: String,
    val gameState: GameState = INITIALIZED
)

enum class GameState {
    INITIALIZED, RUNNING, FINISHED
}
