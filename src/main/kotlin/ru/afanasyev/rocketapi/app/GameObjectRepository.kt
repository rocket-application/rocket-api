package ru.afanasyev.rocketapi.app

import ru.afanasyev.rocketapi.domain.GameObject

interface GameObjectRepository {
    fun getGameObjects(gameId: String): List<GameObject>

    fun getMoon(gameId: String): GameObject

    fun getEarth(gameId: String): GameObject

    fun getPlayer(gameId: String): GameObject
}