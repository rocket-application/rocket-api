package ru.afanasyev.rocketapi.app.repository;

import org.springframework.stereotype.Component;
import ru.afanasyev.rocketapi.app.GameRepository;
import ru.afanasyev.rocketapi.domain.Game;
import ru.afanasyev.rocketapi.domain.GameStatus;
import ru.afanasyev.rocketapi.domain.GameType;

import java.util.List;

@Component
public class GameRepositoryImpl implements GameRepository {
    @Override
    public List<Game> findAllGames(GameType gameType, GameStatus gameStatus) {
        // TODO Папа
        // Придумать как хранить состояние игр, не забыть что у нас уже есть 1 репозиторий см. GameObjectRepositoryImpl
        // необходимо что бы состояние игры и стостояние обьектов было синхронизировано и метод
        return List.of();
    }
}
