package com.games.gorlami.blockrunner.states.game.view;

import android.view.MotionEvent;
import android.view.View;

import com.games.gorlami.blockrunner.states.game.gameObjects.Sprite;

import java.util.List;

import common.MvcView;

/**
 * Custom view for game activity.
 */
public interface MvcGameView extends MvcView {
    interface GameListener {
        boolean onScreenTouched(View view, MotionEvent event);
    }

    interface DrawListener {
        List<Sprite> getSpriteListCopy();
    }

    void drawOnNextUpdate(List<Sprite> spriteList);
    void setGameListener(GameListener listenerInstance);
    void incrementScoreUi();
}
