/*
 ****************************************
 * Created by Eoin Gorman on 06/02/2018.
 ****************************************
 */

package com.games.gorlami.blockrunner.states.mainMenu.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.games.gorlami.blockrunner.R;
import com.games.gorlami.blockrunner.states.game.gameActivity;


/**
 * Activity that represents the main menu screen.
 */
public final class mainMenuActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_menu_layout);
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

    public void startGame() {
        Intent intent = new Intent(this, gameActivity.class);
        startActivity(intent);
    }
}
