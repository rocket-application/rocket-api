package ru.afanasyev.rocketapi

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.ConfigurableApplicationContext
import ru.afanasyev.rocketapi.app.DistanceService
import ru.afanasyev.rocketapi.app.GameService
import ru.afanasyev.rocketapi.domain.GameObject

@SpringBootApplication
class RocketApiApplication

fun main(args: Array<String>) {
    val application = runApplication<RocketApiApplication>(*args)

    test(application)
}

// Можно вызывать для отладки кода
private fun test(application: ConfigurableApplicationContext) {
    val service = application.getBean(GameService::class.java)
    println(service.getDistanceToMoon("GAME_1"))
}


