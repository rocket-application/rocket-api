package ru.afanasyev.rocketapi.app.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import ru.afanasyev.rocketapi.app.util.DistanceService;
import ru.afanasyev.rocketapi.app.game.object.GameObjectRepository;
import ru.afanasyev.rocketapi.app.game.object.GameObjectService;
import ru.afanasyev.rocketapi.app.game.GameState;
import ru.afanasyev.rocketapi.domain.GameObject;
import ru.afanasyev.rocketapi.domain.ObjectPosition;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class GameObjectServiceImpl implements GameObjectService {
    private static final Logger logger = LoggerFactory.getLogger(GameObjectServiceImpl.class);

    private final DistanceService distanceService;
    private final GameObjectRepository gameObjectRepository;

    public GameObjectServiceImpl(DistanceService distanceService, GameObjectRepository gameObjectRepository) {
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
    public void printGameObjects(String gameId) {
        List<GameObject> gameObjects = gameObjectRepository.getGameObjects(gameId);
        logger.info(gameObjects.stream().map(GameObject::toString).collect(Collectors.joining(" | ")));
    }

    @Override
    public GameState gatGameState(String gameId) {
        // TODO Папа
        // Метод получения состояния игры, наполняем данными игры
        return null;
    }

    @Override
    public void moveGameObjects(String gameId) {
        // TODO Папа
        // Расчет всех новых позиций движемых обьектов игры
    }

    @Override
    public void changePlayerVector(String gameId, ObjectPosition newVector, String playerId) {
        // TODO Папа
        // Вытянуть обьект Player по его id, обновить значение vector`а
    }
}
