package com.games.gorlami.blockrunner.states.game.view;

import android.content.Context;
import android.graphics.Canvas;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.games.gorlami.blockrunner.states.game.gameObjects.Sprite;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Custom game view to which we draw Sprite objects.
 */
public class GameCanvas extends View {
    private final AtomicBoolean drawing = new AtomicBoolean(false);
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

    public boolean isDrawing() {
        return drawing.get();
    }

    public void setDrawing(boolean value) {
        drawing.set(value);
    }

    public void setOnDrawListener(MvcGameView.DrawListener newDrawListener) {
        drawListener = newDrawListener;
    }

    @Override
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //Draw all our sprites
        if (drawListener != null) {
            for (Sprite sprite : drawListener.getSpriteListCopy()) {
                canvas.drawBitmap(sprite.getBmp(), null, sprite.getDestRect(), null);
            }
        }
        drawing.set(false);
    }
}
