package ru.afanasyev.rocketapi

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import ru.afanasyev.rocketapi.app.DistanceService
import ru.afanasyev.rocketapi.domain.GameObject

@SpringBootApplication
class RocketApiApplication

fun main(args: Array<String>) {
    val application = runApplication<RocketApiApplication>(*args)

    val service = application.getBean(DistanceService::class.java)
    println(service.calculateDistance(GameObject(), GameObject()))
}
