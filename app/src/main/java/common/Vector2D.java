package common;

/**
 * Class that represents a vector in 2D space.
 */
public class Vector2D {
    public float x;
    public float y;

    public Vector2D() {
        x = 0;
        y = 0;
    }

    public Vector2D(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Vector2D(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public Vector2D(double x, double y) {
        this.x = (float)x;
        this.y = (float)y;
    }

    public Vector2D getAddResult(Vector2D other) {
        return new Vector2D(x + other.x, y + other.y);
    }

    public Vector2D getSubtractResult(Vector2D other) {
        return new Vector2D(x - other.x, y - other.y);
    }

    public Vector2D getScaleResult(float scalar) {
        return new Vector2D(x * scalar, y * scalar);
    }

    public double getMagnitude(){
        return Math.sqrt((x*x) + (y*y));
    }

    public void normalise() {
        double mag = getMagnitude();
        x /= mag;
        y /= mag;
    }

    public Vector2D getNormalisedCopy() {
        double mag = getMagnitude();
        return new Vector2D((x / mag),(y / mag));
    }
}
