package ru.afanasyev.rocketapi.domain

class Player(
    val playerId: String,
    position: ObjectPosition? = null,
    name: String? = null,
    vector: ObjectPosition? = null,
    weight: Double? = null,
    size: Double? = null,
): GameObject(position, name, vector, weight, size)