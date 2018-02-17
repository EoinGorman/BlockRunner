package common;

import android.graphics.RectF;

/**
 * Interface used for collision handling.
 */
public interface Collidable {
    void onCollide(Collidable other);
    RectF getBounds();
    Constants.Game.ObjectTypes getObjectType();
}
