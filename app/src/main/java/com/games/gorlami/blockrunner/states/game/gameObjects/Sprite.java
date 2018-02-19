package com.games.gorlami.blockrunner.states.game.gameObjects;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.RectF;

import common.Vector2D;

/**
 * Class for holding bitmap and position to draw.
 */
public class Sprite {
    private Bitmap bmp;
    private Vector2D position;
    private int depth;
    private int width, height;
    private RectF destRect;

    private Sprite() {
        depth = 0;
        destRect = new RectF();
        position = new Vector2D(0,0);
    }

    public Sprite(Sprite other) {
        bmp = other.getBmp();
        destRect = new RectF(other.getDestRect());
        position = new Vector2D(other.getPosition());
        depth = other.getDepth();
        width = other.getWidth();
        height = other.getHeight();
    }

    public Sprite(Resources resources, int resourceId, Vector2D pos, int layerDepth) {
        this();
        bmp = BitmapFactory.decodeResource(resources, resourceId);
        depth = layerDepth;
        width = bmp.getWidth();
        height = bmp.getHeight();
        setPosition(pos);
    }

    public final RectF getDestRect() {
        return destRect;
    }

    public final Vector2D getPosition() { return position; }

    public void setPosition(final Vector2D newPosition) {
        position.x = newPosition.x;
        position.y = newPosition.y;

        destRect.left = position.x - (width/2);
        destRect.top = position.y - (height/2);
        destRect.right = destRect.left + width;
        destRect.bottom = destRect.top + height;
    }

    public final Bitmap getBmp() { return bmp; }

    public void setBmp(final Bitmap bitmap) { bmp = bitmap; }

    public final int getWidth() {
        return width;
    }

    public final int getHeight() {
        return height;
    }

    public final int getDepth() { return depth; }

    public void setDepth(final int layerDepth) { depth = layerDepth; }
}
