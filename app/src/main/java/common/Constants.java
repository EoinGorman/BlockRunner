package common;

/**
 * Class containing various constants used throughout game.
 */
public final class Constants {
    private Constants(){};

    public static class Physics{
        public final static Vector2D GRAVITY = new Vector2D(0,9.84f);
        public final static float SCALE = 17;
        private Physics() {};
    }

    public static class Game{
        public final static float FLOOR_HEIGHT_FROM_BOTTOM = 100.0f;
        public enum ObjectTypes {
            GROUND,
            PLAYER,
            OBSTACLE
        }
        private Game() {};
    }
}
