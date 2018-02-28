package com.games.gorlami.blockrunner.states.game;

import com.games.gorlami.blockrunner.states.game.gameObjects.Obstacle;

import common.Vector2D;

/**
 * Object that handles the creation of obstacle objects.
 * Might make more than just BOX in future...
 */
public class ObstacleFactory {
    public enum RELATIVE_POSITION {
        ABOVE,
        BEHIND
    }

    public Obstacle createObstacleInFormation(Obstacle other, RELATIVE_POSITION offsetDirection) {
        Vector2D spawnPosition = new Vector2D(other.getPosition());
        Vector2D startingVelocity = new Vector2D(other.getVelocity());
        switch (offsetDirection) {
            case ABOVE:
                spawnPosition.y -= other.getBounds().height();
                break;
            case BEHIND:
                spawnPosition.x += other.getBounds().width();
                break;
        }

        return new Obstacle(spawnPosition, startingVelocity);
    }

    public Obstacle createObstacle(Vector2D spawnPosition, Vector2D startingVelocity) {
        return new Obstacle(spawnPosition, startingVelocity);
    }
}
