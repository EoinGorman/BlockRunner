/*
 ****************************************
 * Created by Eoin Gorman on 06/02/2018.
 ****************************************
 */
package com.games.gorlami.blockrunner.states.mainMenu.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.games.gorlami.blockrunner.R;

/**
 * Custom view for mainMenuActivity.
 */
public class mvcMainMenuViewImpl implements mvcMainMenuView {

    private View mRootView;
    private MainMenuListener mListener;
    private Button startButton;

    public mvcMainMenuViewImpl(LayoutInflater inflater, ViewGroup container) {
        mRootView = inflater.inflate(R.layout.main_menu_layout, container, false);
        initialize();

        mRootView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mListener != null) {
                    mListener.onBackgroundClicked();
                }
            }
        });
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mListener != null) {
                    mListener.onGameStartButtonClicked();
                }
            }
        });
    }

    private void initialize() {
        startButton = mRootView.findViewById(R.id.button);
    }

    @Override
    public void setBackgroundColor(int funkyNewStyle) {
        mRootView.setBackgroundColor(funkyNewStyle);
    }

    @Override
    public void setListener(MainMenuListener listenerInstance) {
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
