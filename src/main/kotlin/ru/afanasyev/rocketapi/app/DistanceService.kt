package ru.afanasyev.rocketapi.app

import ru.afanasyev.rocketapi.domain.GameObject

interface DistanceService {
    fun calculateDistance(first: GameObject, second: GameObject): Double
}