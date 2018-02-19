/*
 ****************************************
 * Created by Eoin Gorman on 06/02/2018.
 ****************************************
 */
package com.games.gorlami.blockrunner.states.game.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.games.gorlami.blockrunner.R;
import com.games.gorlami.blockrunner.states.game.gameObjects.Sprite;

import java.util.ArrayList;
import java.util.List;

/**
 * Custom view for GameActivity.
 */
public class MvcGameViewImpl implements MvcGameView {
    private View mRootView;
    private GameCanvas gameCanvas;
    private GameListener mListener;
    private TextView scoreCounter;

    public MvcGameViewImpl(LayoutInflater inflater, ViewGroup container) {
        mRootView = inflater.inflate(R.layout.game_layout, container, false);
        initialize();

        mRootView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (mListener != null) {
                    return mListener.onScreenTouched(v, event);
                }
                return false;
            }
        });
    }

    private void initialize() {
        scoreCounter = mRootView.findViewById(R.id.score_counter);
        gameCanvas = mRootView.findViewById(R.id.game_canvas);
    }

    @Override
    public void incrementScoreUi() {
        int score = Integer.decode(String.valueOf(scoreCounter.getText()));
        score++;
        scoreCounter.setText(String.valueOf(score));
    }

    @Override
    public void drawOnNextUpdate(List<Sprite> sprites) {
        if(!gameCanvas.isDrawing()) {
            gameCanvas.setDrawing(true);
            gameCanvas.setSpritesToDraw(sprites);
            gameCanvas.postInvalidate();
        }
    }

    @Override
    public void setGameListener(GameListener listenerInstance) {
        mListener = listenerInstance;
    }

    @Override
    public View getRootView() {
        return mRootView;
    }

    @Override
    public Bundle getViewState() {
        return null;
    }

}
