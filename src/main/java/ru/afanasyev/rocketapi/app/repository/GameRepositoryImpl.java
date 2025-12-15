package ru.afanasyev.rocketapi.app.repository;

import org.springframework.stereotype.Component;
import ru.afanasyev.rocketapi.app.GameRepository;
import ru.afanasyev.rocketapi.domain.Game;

import java.util.List;

@Component
public class GameRepositoryImpl implements GameRepository {
    @Override
    public List<Game> findAllRunningGames() {
        // TODO Папа
        return List.of();
    }
}
