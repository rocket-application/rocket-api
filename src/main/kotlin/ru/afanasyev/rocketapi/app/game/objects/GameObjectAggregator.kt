package ru.afanasyev.rocketapi.app.game.objects

import ru.afanasyev.rocketapi.domain.Earth
import ru.afanasyev.rocketapi.domain.GameObject
import ru.afanasyev.rocketapi.domain.Moon
import ru.afanasyev.rocketapi.domain.Player

class GameObjectAggregator(val source: List<GameObject>) : List<GameObject> by source {
    fun getPlayer(): Player {
        return this.first { gameObject -> gameObject is Player } as Player
    }

    fun getOtherObject(except: GameObject): List<GameObject> {
        return this.filter { gameObject -> gameObject != except }
    }

    fun getMoon(): Moon {
        return this.first { it == Moon } as Moon
    }

    fun getEarth(): Earth {
        return this.first { it == Earth } as Earth
    }
}
