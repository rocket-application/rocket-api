package ru.afanasyev.rocketapi.app.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import ru.afanasyev.rocketapi.app.DistanceService;
import ru.afanasyev.rocketapi.app.GameObjectRepository;
import ru.afanasyev.rocketapi.app.GameService;
import ru.afanasyev.rocketapi.domain.GameObject;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class GameServiceImpl implements GameService {
    private static final Logger logger = LoggerFactory.getLogger(GameServiceImpl.class);

    private final DistanceService distanceService;
    private final GameObjectRepository gameObjectRepository;

    public GameServiceImpl(DistanceService distanceService, GameObjectRepository gameObjectRepository) {
        this.distanceService = distanceService;
        this.gameObjectRepository = gameObjectRepository;
    }

    @Override
    public double getDistanceToMoon(String gameId) {
        GameObject moon = gameObjectRepository.getMoon(gameId);
        GameObject player = gameObjectRepository.getPlayer(gameId);
        return distanceService.calculateDistance(player, moon);
    }

    @Override
    public double getDistanceToEarth(String gameId) {
        GameObject earth = gameObjectRepository.getEarth(gameId);
        GameObject player = gameObjectRepository.getPlayer(gameId);
        return distanceService.calculateDistance(player, earth);
    }

    @Override
    public void moveGameObjects(String gameId) {
        // TODO Папа
    }

    @Override
    public void printGameObjects(String gameId) {
        List<GameObject> gameObjects = gameObjectRepository.getGameObjects(gameId);
        logger.info(gameObjects.stream().map(GameObject::toString).collect(Collectors.joining(" | ")));
    }
}
