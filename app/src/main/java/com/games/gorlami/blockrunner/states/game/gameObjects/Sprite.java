package com.games.gorlami.blockrunner.states.game.gameObjects;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import common.Vector2D;

/**
 * Class for holding bitmap and position to draw.
 */
public class Sprite {
    private Bitmap bmp;
    private Vector2D position;
    private int depth = 0;
    private int width, height;

    public Sprite(Resources resources, int resourceId, Vector2D pos, int layerDepth) {
        bmp = BitmapFactory.decodeResource(resources, resourceId);
        position = pos;
        depth = layerDepth;
        width = bmp.getWidth();
        height = bmp.getHeight();
    }

    public final Vector2D getPosition() { return position; }

    public void setPosition(final Vector2D newPosition) { position = newPosition; }

    public final Bitmap getBmp() { return bmp; }

    public void setBmp(final Bitmap bitmap) { bmp = bitmap; }

    public final int getDepth() { return depth; }

    public void setDepth(final int layerDepth) { depth = layerDepth; }
}
