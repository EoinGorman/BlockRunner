/*
 ****************************************
 * Created by Eoin Gorman on 06/02/2018.
 ****************************************
 */

package com.games.gorlami.blockrunner.states.mainMenu;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;

import com.games.gorlami.blockrunner.states.game.GameActivity;
import com.games.gorlami.blockrunner.states.mainMenu.view.MvcMainMenuView;
import com.games.gorlami.blockrunner.states.mainMenu.view.MvcMainMenuViewImpl;

import java.util.Random;

/**
 * Activity that represents the main menu screen.
 */
public final class MainMenuActivity extends Activity implements MainMenuPresenter {
    private MvcMainMenuView mvcView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mvcView = new MvcMainMenuViewImpl(LayoutInflater.from(this), null);
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
    public void onGameStartButtonClicked() {
        Intent intent = new Intent(this, GameActivity.class);
        startActivity(intent);
    }

    @Override
    public boolean onBackgroundTouched(View view, MotionEvent event) {
        if(event.getAction() == MotionEvent.ACTION_MOVE) {
            Random rand = new Random();
            mvcView.setBackgroundColor(Color.argb(255, rand.nextInt(256),
                    rand.nextInt(256), rand.nextInt(256)));
        }
        else if(event.getAction() == MotionEvent.ACTION_DOWN) {
            mvcView.setBackgroundColor(Color.RED);
            return true;
        }
        else if(event.getAction() == MotionEvent.ACTION_UP) {
            mvcView.setBackgroundColor(Color.BLUE);
        }
        else if(event.getAction() == MotionEvent.ACTION_CANCEL) {
            mvcView.setBackgroundColor(Color.BLACK);
        }
        return false;
    }
}
