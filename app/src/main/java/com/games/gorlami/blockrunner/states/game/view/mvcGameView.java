package com.games.gorlami.blockrunner.states.game.view;

import common.mvcView;

/**
 * Custom view for game activity.
 */
public interface mvcGameView extends mvcView {
    interface GameListener {
        void onScreenClicked();
    }

    void setListener(GameListener listenerInstance);
    void playerSpriteJump();
    void incrementScoreUi();
}
