package com.games.gorlami.blockrunner.states.game.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.games.gorlami.blockrunner.states.game.gameObjects.Sprite;

/**
 * Custom game view to which we draw Sprite objects.
 */
public class GameCanvas extends View {
    private MvcGameView.DrawListener drawListener;

    public GameCanvas(Context context) {
        super(context);
    }

    public GameCanvas(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public GameCanvas(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public GameCanvas(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    public void setOnDrawListener(MvcGameView.DrawListener newDrawListener) {
        drawListener = newDrawListener;
    }

    @Override
    synchronized public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //Draw all our sprites
        if(drawListener != null) {
            for(Sprite sprite : drawListener.getSpriteList()) {
                Rect dest = new Rect((int)sprite.getPosition().x, (int)sprite.getPosition().y, (int)sprite.getPosition().x + sprite.getBmp().getWidth(), (int)sprite.getPosition().y + sprite.getBmp().getHeight());
                canvas.drawBitmap(sprite.getBmp(), null, dest, null);
            }
        }
    }
}
