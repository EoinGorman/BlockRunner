package com.games.gorlami.blockrunner.states.game;

import com.games.gorlami.blockrunner.states.game.gameObjects.Obstacle;

import java.util.ArrayList;
import java.util.List;

import common.Vector2D;

/**
 * Holds list of all created obstacles.
 */
public class ObstacleHandler {
    public enum FORMATION {
        SINGLE,
        DOUBLE,
        DOUBLE_STACK
    }
    private Vector2D originPosition;
    private Vector2D abovePosition;
    private Vector2D behindPosition;
    private Vector2D startingVelocity;
    private List<Obstacle> obstacles;
    private ObstacleFactory obstacleFactory;

    public ObstacleHandler(Vector2D originPos){
        originPosition = originPos;
        abovePosition = new Vector2D(originPos.x, originPos.y); //todo better solution for getting/setting possible formation positions
        behindPosition = new Vector2D(originPos.x, originPos.y);
        startingVelocity = new Vector2D(-1,0);
        obstacles = new ArrayList<>();
        obstacleFactory = new ObstacleFactory();
    };

    public void update(float deltaTime) {
        for (Obstacle obstacle : obstacles) {
            obstacle.update(deltaTime);
        }
    }

    public void spawnNewWave(FORMATION formation){
        //pass difficulty
        //randomly pick new FORMATION between 0-difficulty
        //allows this to select formation based on difficulty coming from game
        //consider expanding obstacleFactory to include different obstacles for different formations
        switch (formation){
            case SINGLE:
                obstacles.add(obstacleFactory.createObstacle(originPosition, startingVelocity));
                break;
            case DOUBLE:
                obstacles.add(obstacleFactory.createObstacle(originPosition, startingVelocity));
                obstacles.add(obstacleFactory.createObstacle(behindPosition, startingVelocity));
                break;
            case DOUBLE_STACK:
                obstacles.add(obstacleFactory.createObstacle(originPosition, startingVelocity));
                obstacles.add(obstacleFactory.createObstacle(abovePosition, startingVelocity));
                break;
        }
    }

    public final List<Obstacle> getObstacles() {
        return obstacles;
    }
}
