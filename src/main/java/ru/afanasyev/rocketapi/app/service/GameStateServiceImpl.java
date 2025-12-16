package ru.afanasyev.rocketapi.app.service;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;
import ru.afanasyev.rocketapi.app.GameRepository;
import ru.afanasyev.rocketapi.app.GameStateService;
import ru.afanasyev.rocketapi.domain.Game;
import ru.afanasyev.rocketapi.domain.GameStatus;

@Component
public class GameStateServiceImpl implements GameStateService {
    private final GameRepository gameRepository;
    private final ApplicationEventPublisher applicationEventPublisher;

    public GameStateServiceImpl(GameRepository gameRepository, ApplicationEventPublisher applicationEventPublisher) {
        this.gameRepository = gameRepository;
        this.applicationEventPublisher = applicationEventPublisher;
    }

    @Override
    public Game startGame() {
        // TODO Папа
        // Создать новую игру, добавить стандартный набор обьектов
        return null;
    }

    @Override
    public void pauseGame(String gameId) {
        Game game = null; // TODO Папа
        // Придумать откуда взять обьект Game. См GameRepositoryImpl
        game.setGameStatus(GameStatus.PAUSED);
    }

    @Override
    public void resumeGame(String gameId) {
        Game game = null; // TODO Папа
        // Придумать откуда взять обьект Game. См GameRepositoryImpl
        game.setGameStatus(GameStatus.RUNNING);
    }

    @Override
    public void finishGame(String gameId) {
        Game game = null; // TODO Папа
        // Придумать откуда взять обьект Game. См GameRepositoryImpl
        game.setGameStatus(GameStatus.FINISHED);
    }
}
