package com.games.gorlami.blockrunner.states;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.games.gorlami.blockrunner.R;

/**
 * Class to load static bitmaps etc.
 */
public final class ResourceLoader {
    public static Bitmap PLAYER_BITMAP;
    public static Bitmap BOX_BITMAP;

    private ResourceLoader(){};

    public static void loadResources(final Resources activityResources) {
        PLAYER_BITMAP = BitmapFactory.decodeResource(activityResources, R.drawable.test);
        BOX_BITMAP = BitmapFactory.decodeResource(activityResources, R.drawable.box);
    }
}
