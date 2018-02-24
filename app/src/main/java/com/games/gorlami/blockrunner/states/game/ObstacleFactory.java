package com.games.gorlami.blockrunner.states.game;

import com.games.gorlami.blockrunner.states.game.gameObjects.Obstacle;

import common.Vector2D;

/**
 * Object that handles the creation of obstacle objects.
 * Might make more than just BOX in future...
 */
public class ObstacleFactory {
    public Obstacle createObstacle(Vector2D spawnPosition, Vector2D startingVelocity) {
        return new Obstacle(spawnPosition, startingVelocity);
    }
}
