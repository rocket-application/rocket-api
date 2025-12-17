package ru.afanasyev.rocketapi.app.repository;

import org.springframework.stereotype.Component;
import ru.afanasyev.rocketapi.app.game.object.GameObjectRepository;
import ru.afanasyev.rocketapi.app.game.object.GameObjectAggregator;
import ru.afanasyev.rocketapi.domain.*;

import java.util.List;
import java.util.Map;

@Component
public class GameObjectRepositoryImpl implements GameObjectRepository {
    private Map<String, List<GameObject>> gameObjects = initializeGame();
    private GameObject player;

    // TODO Отрефакторить, на текущем этапе будем храним все состояние игры прямо в коде
    private Map<String, List<GameObject>> initializeGame() {
        return Map.of("GAME_1", List.of(Earth.INSTANCE, Moon.INSTANCE, setUpPlayer()));
    }

    private GameObject setUpPlayer() {
        player = new Player("PLAYER_1", new ObjectPosition(0.0, 6756320.0), "Player",new ObjectPosition(1.0, 1.0),1000.0,100.0);
        return player;
    }

    @Override
    public GameObjectAggregator getGameObjects(String gameId) {
        return new GameObjectAggregator(gameObjects.get(gameId));
    }

    @Override
    public GameObject getMoon(String gameId) {
        return getGameObject(gameId, Moon.INSTANCE);
    }

    @Override
    public GameObject getEarth(String gameId) {
        return getGameObject(gameId, Earth.INSTANCE);
    }

    @Override
    public GameObject getPlayer(String gameId) {
        return getGameObject(gameId, player);
    }

    private GameObject getGameObject(String gameId, GameObject gameObject) {
        return gameObjects.get(gameId).stream()
            .filter(object -> object.equals(gameObject))
            .findFirst()
            .orElseThrow();
    }
}
