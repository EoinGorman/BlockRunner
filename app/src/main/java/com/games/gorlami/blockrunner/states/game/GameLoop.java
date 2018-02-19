package com.games.gorlami.blockrunner.states.game;

/**
 * Custom Thread that will call functions from GamePresenter.
 */
public final class GameLoop implements Runnable {
    private boolean running = true;
    private static final float ONE_SECOND_IN_MILLISECONDS = 1000.0f;
    private static final float FRAMERATE = 0.016f;
    private GamePresenter game;
    private long lastFrameTime;
    private long lastUpdateTime;
    private long currentTime;
    private float deltaTime;

    private GameLoop() {
        currentTime = System.currentTimeMillis();
        lastFrameTime = currentTime;
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

            //Set FrameRate for updating gameCanvas
            deltaTime = (currentTime - lastFrameTime) / ONE_SECOND_IN_MILLISECONDS;
            //if(deltaTime > FRAMERATE) {
                lastFrameTime = currentTime;
                game.Draw();
            //}
        }
    }
}
