/*
 ****************************************
 * Created by Eoin Gorman on 06/02/2018.
 ****************************************
 */
package com.games.gorlami.blockrunner.states.mainMenu.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.games.gorlami.blockrunner.R;

/**
 * Custom view for MainMenuActivity.
 */
public class MvcMainMenuViewImpl implements MvcMainMenuView {

    private View mRootView;
    private MainMenuListener mListener;
    private Button startButton;

    public MvcMainMenuViewImpl(LayoutInflater inflater, ViewGroup container) {
        mRootView = inflater.inflate(R.layout.main_menu_layout, container, false);
        initialize();

        mRootView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (mListener != null) {
                    return mListener.onBackgroundTouched(v, event);
                }
                return false;
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
