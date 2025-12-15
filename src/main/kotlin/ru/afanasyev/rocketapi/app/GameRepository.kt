package ru.afanasyev.rocketapi.app

import ru.afanasyev.rocketapi.domain.Game

interface GameRepository {
    fun findAllRunningGames(): List<Game>
}