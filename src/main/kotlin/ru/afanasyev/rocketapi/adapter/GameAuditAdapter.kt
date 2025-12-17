package ru.afanasyev.rocketapi.adapter

import org.slf4j.LoggerFactory
import org.springframework.context.event.EventListener
import org.springframework.stereotype.Component
import ru.afanasyev.rocketapi.app.game.`object`.GameObjectService
import ru.afanasyev.rocketapi.app.event.GameStartEvent
import ru.afanasyev.rocketapi.app.event.GameStatusChangedEvent

@Component
class GameAuditAdapter(
    val gameObjectService: GameObjectService
) {
    companion object {
        private val logger = LoggerFactory.getLogger(GameAuditAdapter::class.java)
    }


    @EventListener
    fun onGameStartEvent(event: GameStartEvent) {
        val gameId = event.game.gameId
        logger.info("Auditing game $gameId start event")
        val gameState = gameObjectService.gatGameState(gameId)
        // TODO Audit
    }

    @EventListener
    fun onGameStatusChangedEvent(event: GameStatusChangedEvent) {
        val gameId = event.game.gameId
        logger.info("Auditing game $gameId status changed: ${event.game.gameStatus}")
        val gameState = gameObjectService.gatGameState(gameId)
        // TODO Audit
    }
}