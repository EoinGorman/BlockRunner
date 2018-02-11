/*
 ****************************************
 * Created by Eoin Gorman on 06/02/2018.
 ****************************************
 */
package com.games.gorlami.blockrunner.states.mainMenu.view;

import android.view.MotionEvent;
import android.view.View;

import common.mvcView;

/**
 * Custom view for mainMenuActivity.
 */
public interface mvcMainMenuView extends mvcView {

    interface MainMenuListener {
        void onGameStartButtonClicked();
        boolean onBackgroundTouched(View view, MotionEvent event);
    }

    void setListener(MainMenuListener listenerInstance);
    void setBackgroundColor(int funkyNewStyle);
}
