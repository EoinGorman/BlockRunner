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

import com.games.gorlami.blockrunner.R;

/**
 * Custom view for mainMenuActivity.
 */
public class mvcMainMenuViewImpl implements mvcMainMenuView {

    private View mRootView;
    private GameStartListener mListener;

    public mvcMainMenuViewImpl(LayoutInflater inflater, ViewGroup container) {
        mRootView = inflater.inflate(R.layout.main_menu_layout, container, false);
        initialize();
        mRootView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mListener != null) {
                    mListener.onGameStartButtonClicked();
                }
            }
        });
    }

    private void initialize() {
        //get UI references here from mRootView.findViewById(R.id.###);
    }

    @Override
    public void setBackgroundColor(int funkyNewStyle) {
        mRootView.setBackgroundColor(funkyNewStyle);
    }

    @Override
    public void setListener(GameStartListener listenerInstance) {
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
