package ru.afanasyev.rocketapi.app.service;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;
import ru.afanasyev.rocketapi.app.game.GameRepository;
import ru.afanasyev.rocketapi.app.game.GameStateService;
import ru.afanasyev.rocketapi.app.event.GameStartEvent;
import ru.afanasyev.rocketapi.app.event.GameStatusChangedEvent;
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
        Game game = null;
        applicationEventPublisher.publishEvent(new GameStartEvent(game));
        return game;
    }

    @Override
    public void pauseGame(String gameId) {
        Game game = null; // TODO Папа
        // Придумать откуда взять обьект Game. См GameRepositoryImpl
        game.setGameStatus(GameStatus.PAUSED);
        applicationEventPublisher.publishEvent(new GameStatusChangedEvent(game));
    }

    @Override
    public void resumeGame(String gameId) {
        Game game = null; // TODO Папа
        // Придумать откуда взять обьект Game. См GameRepositoryImpl
        game.setGameStatus(GameStatus.RUNNING);
        applicationEventPublisher.publishEvent(new GameStatusChangedEvent(game));
    }

    @Override
    public void finishGame(String gameId) {
        Game game = null; // TODO Папа
        // Придумать откуда взять обьект Game. См GameRepositoryImpl
        game.setGameStatus(GameStatus.FINISHED);
        applicationEventPublisher.publishEvent(new GameStatusChangedEvent(game));
    }
}
