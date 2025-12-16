package ru.afanasyev.rocketapi.app

import ru.afanasyev.rocketapi.domain.GameObject

interface ObjectCollisionService {
    /**
     * @return true - если объекты столкнулись, иначе false
     */
    fun checkCollision(first: GameObject, second: GameObject): Boolean
}