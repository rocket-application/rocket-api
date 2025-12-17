package ru.afanasyev.rocketapi.app.util

import ru.afanasyev.rocketapi.domain.GameObject

interface DistanceService {
    fun calculateDistance(first: GameObject, second: GameObject): Double
}