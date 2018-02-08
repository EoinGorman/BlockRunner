/*
 ****************************************
 * Created by Eoin Gorman on 06/02/2018.
 ****************************************
 */

package com.games.gorlami.blockrunner.states.game.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import com.games.gorlami.blockrunner.states.game.gameActivity;

/**
 * Custom view for mainMenuActivity.
 */
public class gameView extends View implements View.OnTouchListener{

    public gameView(Context context) {
        super(context);
        init();
    }

    public gameView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public gameView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    private void init() {
        setOnTouchListener(this);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        view.setBackgroundColor(Color.RED);
        ((gameActivity)getContext()).finish();
        return false;
    }
}
