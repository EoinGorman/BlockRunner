package com.games.gorlami.blockrunner.states.game;

import com.games.gorlami.blockrunner.states.game.view.MvcGameView;

/**
 * Presenter interface for game activity.
 */

interface GamePresenter extends MvcGameView.GameListener {
    void Update(float deltaTime);
    void Draw();
}
