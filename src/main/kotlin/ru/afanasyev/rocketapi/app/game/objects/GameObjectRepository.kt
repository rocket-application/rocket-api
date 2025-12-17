package ru.afanasyev.rocketapi.app.game.objects

import ru.afanasyev.rocketapi.domain.GameObject

interface GameObjectRepository {
    fun getGameObjects(gameId: String): GameObjectAggregator

    fun getMoon(gameId: String): GameObject

    fun getEarth(gameId: String): GameObject

    fun getPlayer(gameId: String): GameObject
}