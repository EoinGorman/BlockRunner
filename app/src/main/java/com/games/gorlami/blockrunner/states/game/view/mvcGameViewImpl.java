/*
 ****************************************
 * Created by Eoin Gorman on 06/02/2018.
 ****************************************
 */
package com.games.gorlami.blockrunner.states.game.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.games.gorlami.blockrunner.R;

/**
 * Custom view for gameActivity.
 */
public class mvcGameViewImpl implements mvcGameView {

    private View mRootView;
    private GameListener mListener;
    private TextView scoreCounter;

    public mvcGameViewImpl(LayoutInflater inflater, ViewGroup container) {
        mRootView = inflater.inflate(R.layout.game_layout, container, false);
        initialize();

        mRootView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mListener != null) {
                    mListener.onScreenClicked();
                }
            }
        });

    }

    private void initialize() {
        scoreCounter = mRootView.findViewById(R.id.score_counter);
    }

    @Override
    public void playerSpriteJump() {
        //Make sprite animate up/down
    }

    @Override
    public void incrementScoreUi() {
        int score = Integer.decode(String.valueOf(scoreCounter.getText()));
        score++;
        scoreCounter.setText(String.valueOf(score));
    }

    @Override
    public void setListener(GameListener listenerInstance) {
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
