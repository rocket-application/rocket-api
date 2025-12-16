package ru.afanasyev.rocketapi.app

import ru.afanasyev.rocketapi.domain.Game
import ru.afanasyev.rocketapi.domain.GameObject

data class GameState(
    val game: Game,
    val gameObjects: List<GameObject>,
    val distanceToMoon: Double,
    val distanceToEarth: Double,
)
