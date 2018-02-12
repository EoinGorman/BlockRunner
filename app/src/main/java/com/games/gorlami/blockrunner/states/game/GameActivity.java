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

import com.games.gorlami.blockrunner.R;
import com.games.gorlami.blockrunner.states.game.gameObjects.Sprite;
import com.games.gorlami.blockrunner.states.game.view.MvcGameView;
import com.games.gorlami.blockrunner.states.game.view.MvcGameViewImpl;

import java.util.ArrayList;

import common.Vector2D;

/**
 * Activity that represents the game screen.
 */
public final class GameActivity extends Activity implements GamePresenter {
    private MvcGameView mvcView;
    private Sprite testSprite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mvcView = new MvcGameViewImpl(LayoutInflater.from(this), null);
        mvcView.setGameListener(this);
        setContentView(mvcView.getRootView());
    }

    @Override
    protected void onStart() {
        super.onStart();

        //Create and position a sprite
        testSprite = new Sprite(getResources(), R.drawable.test, new Vector2D(50,50), 0);
        ArrayList<Sprite> lisp = new ArrayList<>();
        lisp.add(testSprite);
        mvcView.drawOnNextUpdate(lisp);
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
            return true;
        }
        return false;
    }
}
