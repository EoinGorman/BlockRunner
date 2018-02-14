package com.games.gorlami.blockrunner.states.game;

/**
 * Custom Thread that will call functions from GamePresenter.
 */
public final class GameLoop implements Runnable {
    private boolean running = true;
    private static final float ONE_SECOND_IN_MILLISECONDS = 1000.0f;
    private GamePresenter game;
    private long lastFrameTime;
    private long currentFrameTime = System.currentTimeMillis();
    private float deltaTime;

    public GameLoop(GamePresenter newGame) {
        game = newGame;
    }

    public void terminate() {
        running = false;
    }

    @Override
    public void run() {
        while (running) {
            lastFrameTime = currentFrameTime;
            currentFrameTime = System.currentTimeMillis();
            deltaTime = (currentFrameTime - lastFrameTime) / ONE_SECOND_IN_MILLISECONDS;

            game.Update(deltaTime);
            game.Draw();
        }
    }
}
