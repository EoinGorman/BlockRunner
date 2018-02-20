package com.games.gorlami.blockrunner.states.game;

/**
 * Custom Thread that will call functions from GamePresenter.
 */
public final class GameLoop implements Runnable {
    private boolean running = true;
    private static final float ONE_SECOND_IN_MILLISECONDS = 1000.0f;
    private GamePresenter game;
    private long lastUpdateTime;
    private long currentTime;
    private float deltaTime;

    private GameLoop() {
        currentTime = System.currentTimeMillis();
    }

    public GameLoop(GamePresenter newGame) {
        this();
        game = newGame;
    }

    public void terminate() {
        running = false;
    }

    @Override
    public void run() {
        while (running) {
            //Update game logic as quickly as possible
            lastUpdateTime = currentTime;
            currentTime = System.currentTimeMillis();
            deltaTime = (currentTime - lastUpdateTime) / ONE_SECOND_IN_MILLISECONDS;
            game.Update(deltaTime);
            game.Draw();
        }
    }
}
