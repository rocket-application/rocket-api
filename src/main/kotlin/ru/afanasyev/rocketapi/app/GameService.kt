package ru.afanasyev.rocketapi.app

interface GameService {
    fun getDistanceToMoon(gameId: String): Double

    fun getDistanceToEarth(gameId: String): Double
}