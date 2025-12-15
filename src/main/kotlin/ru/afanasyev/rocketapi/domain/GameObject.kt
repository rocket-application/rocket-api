package ru.afanasyev.rocketapi.domain

open class GameObject(
    var position: ObjectPosition? = null,
    val name: String? = null,
    var vector: ObjectPosition? = null,
    var weight: Double? = null,
)
