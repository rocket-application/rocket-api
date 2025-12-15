package ru.afanasyev.rocketapi.app;

import org.springframework.stereotype.Component;
import ru.afanasyev.rocketapi.domain.GameObject;

@Component
public class GameServiceImpl implements GameService {
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
        // TODO Папа
        GameObject earth = gameObjectRepository.getEarth(gameId);
        GameObject player = gameObjectRepository.getPlayer(gameId);
        return distanceService.calculateDistance(player, earth);
    }
}
