/*
 ****************************************
 * Created by Eoin Gorman on 06/02/2018.
 ****************************************
 */
package com.games.gorlami.blockrunner.states.mainMenu.view;

import common.mvcView;

/**
 * Custom view for mainMenuActivity.
 */
public interface mvcMainMenuView extends mvcView {

    interface MainMenuListener {
        void onGameStartButtonClicked();
        void onBackgroundClicked();
    }

    void setListener(MainMenuListener listenerInstance);
    void setBackgroundColor(int funkyNewStyle);
}
