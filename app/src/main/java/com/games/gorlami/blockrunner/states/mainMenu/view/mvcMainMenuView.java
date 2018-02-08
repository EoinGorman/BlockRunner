/*
 ****************************************
 * Created by Eoin Gorman on 06/02/2018.
 ****************************************
 */
package com.games.gorlami.blockrunner.states.mainMenu.view;

/**
 * Custom view for mainMenuActivity.
 */
public interface mvcMainMenuView extends mvcView {

    interface GameStartListener {
        void onGameStartButtonClicked();
    }

    void setBackgroundColor(int funkyNewStyle);
    void setListener(GameStartListener listenerInstance);
}
