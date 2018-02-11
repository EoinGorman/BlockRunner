/*
 ****************************************
 * Created by Eoin Gorman on 06/02/2018.
 ****************************************
 */

package com.games.gorlami.blockrunner.states.game;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;

import com.games.gorlami.blockrunner.states.game.view.mvcGameView;
import com.games.gorlami.blockrunner.states.game.view.mvcGameViewImpl;

/**
 * Activity that represents the game screen.
 */
public final class gameActivity extends Activity implements gamePresenter {
    private mvcGameView mvcView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mvcView = new mvcGameViewImpl(LayoutInflater.from(this), null);
        mvcView.setListener(this);
        setContentView(mvcView.getRootView());
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public boolean onScreenTouched(View view, MotionEvent event) {
        if(event.getAction() == MotionEvent.ACTION_DOWN) {
            mvcView.incrementScoreUi();
        }
        return false;
    }
}
