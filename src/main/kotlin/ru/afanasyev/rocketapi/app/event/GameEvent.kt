package ru.afanasyev.rocketapi.app.event

import ru.afanasyev.rocketapi.domain.Game


sealed class GameEvent(val game: Game)

class GameStatusChangedEvent(game: Game): GameEvent(game)

class GameStartEvent(game: Game): GameEvent(game)