package ru.afanasyev.rocketapi.app

import ru.afanasyev.rocketapi.domain.ObjectPosition

interface GameObjectService {
    fun getDistanceToMoon(gameId: String): Double

    fun getDistanceToEarth(gameId: String): Double

    fun printGameObjects(gameId: String)

    fun gatGameState(gameId: String): GameState

    fun changePlayerVector(gameId: String, newVector: ObjectPosition, playerId: String)

    fun moveGameObjects(gameId: String)
}