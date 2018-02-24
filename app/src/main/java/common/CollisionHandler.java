package common;

import android.graphics.RectF;

import java.util.ArrayList;
import java.util.List;

/**
 * Checks for collisions on objects that implement the "Collidable" interface
 */
public class CollisionHandler {
    private List<Collidable>  objectsToCheck;

    public CollisionHandler() {
        objectsToCheck = new ArrayList<>();
    }

    public void attach(Collidable object) {
        objectsToCheck.add(object);
    }

    public void attach(List<Collidable> objects) {
        objectsToCheck.addAll(objects);
    }

    public void checkCollisions() {
        for (int i = 0; i < objectsToCheck.size() - 1; i++) {
            for (int j = (i + 1); j < objectsToCheck.size(); j++) {
                if (colliding(objectsToCheck.get(i).getBounds(),objectsToCheck.get(j).getBounds())) {
                    objectsToCheck.get(i).onCollide(objectsToCheck.get(j));
                    objectsToCheck.get(j).onCollide(objectsToCheck.get(i));
                }
            }
        }
    }

    //todo overload "colliding" function to take other shapes.
    private boolean colliding(RectF object, RectF other) {
        return RectF.intersects(object, other);
    }
}
