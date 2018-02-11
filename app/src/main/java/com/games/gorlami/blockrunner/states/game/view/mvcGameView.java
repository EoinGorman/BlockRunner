package com.games.gorlami.blockrunner.states.game.view;

import android.view.MotionEvent;
import android.view.View;

import common.mvcView;

/**
 * Custom view for game activity.
 */
public interface mvcGameView extends mvcView {
    interface GameListener {
        boolean onScreenTouched(View view, MotionEvent event);
    }

    void setListener(GameListener listenerInstance);
    void incrementScoreUi();
}
