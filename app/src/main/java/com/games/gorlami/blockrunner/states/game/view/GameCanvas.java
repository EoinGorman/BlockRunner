package com.games.gorlami.blockrunner.states.game.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.games.gorlami.blockrunner.states.game.gameObjects.Sprite;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Custom game view to which we draw Sprite objects.
 */
public class GameCanvas extends View {
    private final AtomicBoolean drawing = new AtomicBoolean(false);
    private List<Sprite> spritesToDraw = new ArrayList<>();

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

    public void setSpritesToDraw(List<Sprite> newSprites) {
        spritesToDraw.clear();
        for(Sprite sprite : newSprites) {
            spritesToDraw.add(new Sprite(sprite));
        }
    }

    @Override
    public void onDraw(Canvas canvas) {
        //Draw all our sprites
        for(int i = 0; i < spritesToDraw.size(); i++) {
            canvas.drawBitmap(spritesToDraw.get(i).getBmp(), null, spritesToDraw.get(i).getDestRect(), null);
        }
        drawing.set(false);
    }
}
