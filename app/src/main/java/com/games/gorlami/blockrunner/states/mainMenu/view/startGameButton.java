/*
 ****************************************
 * Created by Eoin Gorman on 06/02/2018.
 ****************************************
 */

package com.games.gorlami.blockrunner.states.mainMenu.view;

import android.content.Context;
import android.graphics.Canvas;
import android.support.v7.widget.AppCompatButton;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * Custom view for the start game button.
 */
public class startGameButton extends AppCompatButton implements View.OnTouchListener{

    public startGameButton(Context context) {
        super(context);
        init();
    }

    public startGameButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public startGameButton(Context context, AttributeSet attrs, int defStyle) {
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
        ((mainMenuActivity)getContext()).startGame();
        return false;
    }
}
