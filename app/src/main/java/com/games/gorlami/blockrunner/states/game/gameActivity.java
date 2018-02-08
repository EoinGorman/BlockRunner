/*
 ****************************************
 * Created by Eoin Gorman on 06/02/2018.
 ****************************************
 */

package com.games.gorlami.blockrunner.states.game;

import android.app.Activity;
import android.os.Bundle;

import com.games.gorlami.blockrunner.R;

/**
 * Activity that represents the gameplay screen.
 */
public final class gameActivity extends Activity {
    @Override
    public void onCreate(Bundle savedInstance) {
        super.onCreate(savedInstance);
        setContentView(R.layout.game_layout);
    }
}
