package com.games.gorlami.blockrunner.states.game;

import com.games.gorlami.blockrunner.states.game.view.MvcGameView;

/**
 * Presenter interface for game activity.
 */

interface GamePresenter extends MvcGameView.GameListener {
    void update(float deltaTime);
    void draw();
}
