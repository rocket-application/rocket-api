package ru.afanasyev.rocketapi.app

import ru.afanasyev.rocketapi.domain.Game
import ru.afanasyev.rocketapi.domain.GameStatus

data class GameStatusChangedEvent(
    val newStatus: GameStatus,
    val game: Game,
)
