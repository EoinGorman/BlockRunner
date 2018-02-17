package common;

/**
 * Class containing various constants used throughout game.
 */
public final class Constants {
    private Constants(){};

    public static class Physics{
        public final static Vector2D GRAVITY = new Vector2D(0,9.84f);
        private Physics() {};
    }

    public static class Game{
        public final static float FLOOR_HEIGHT = 500.0f;
        public enum ObjectTypes {
            GROUND,
            PLAYER
        }
        private Game() {};
    }
}
