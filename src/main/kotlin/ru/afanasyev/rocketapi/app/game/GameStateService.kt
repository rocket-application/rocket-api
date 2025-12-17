package ru.afanasyev.rocketapi.app.game

import ru.afanasyev.rocketapi.domain.Game

interface GameStateService {
    fun startGame(): Game

    fun pauseGame(gameId: String)

    fun resumeGame(gameId: String)

    fun finishGame(gameId: String)
}