/*
 ****************************************
 * Created by Eoin Gorman on 06/02/2018.
 ****************************************
 */

package com.games.gorlami.blockrunner.states.mainMenu.view;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.ViewGroup;

/**
 * Custom view for mainMenuActivity.
 */
public class mainMenuView extends ViewGroup {

    public mainMenuView(Context context) {
        super(context);
        init();
    }

    public mainMenuView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public mainMenuView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    @Override
    protected void onLayout(boolean b, int i, int i1, int i2, int i3) {

    }

    private void init() {
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

}
