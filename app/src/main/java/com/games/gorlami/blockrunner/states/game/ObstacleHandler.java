package com.games.gorlami.blockrunner.states.game;

import com.games.gorlami.blockrunner.states.game.gameObjects.Obstacle;
import com.games.gorlami.blockrunner.states.game.gameObjects.Sprite;

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
    private Vector2D startingVelocity;
    private List<Obstacle> obstacles;
    private List<Sprite> sprites;
    private ObstacleFactory obstacleFactory;

    public ObstacleHandler(Vector2D originPos){
        originPosition = originPos;
        startingVelocity = new Vector2D(-1,0);
        obstacles = new ArrayList<>();
        obstacleFactory = new ObstacleFactory();
    };

    public void update(float deltaTime) {
        for (Obstacle obstacle : obstacles) {
            obstacle.update(deltaTime);
        }
    }

    public ArrayList<Obstacle> spawnNewWave(FORMATION formation){
        //pass difficulty
        //randomly pick new FORMATION between 0-difficulty
        //allows this to select formation based on difficulty coming from game
        //consider expanding obstacleFactory to include different obstacles for different formations
        ArrayList<Obstacle> newObstacles = new ArrayList<>();
        switch (formation){
            case SINGLE:
                newObstacles.add(obstacleFactory.createObstacle(originPosition, startingVelocity));
                break;
            case DOUBLE:
                newObstacles.add(obstacleFactory.createObstacle(originPosition, startingVelocity));
                newObstacles.add(obstacleFactory.createObstacleInFormation(newObstacles.get(newObstacles.size()-1),
                                                                            ObstacleFactory.RELATIVE_POSITION.BEHIND));
                break;
            case DOUBLE_STACK:
                newObstacles.add(obstacleFactory.createObstacle(originPosition, startingVelocity));
                newObstacles.add(obstacleFactory.createObstacleInFormation(newObstacles.get(newObstacles.size()-1),
                                                                            ObstacleFactory.RELATIVE_POSITION.ABOVE));
                break;
        }
        obstacles.addAll(newObstacles);
        return newObstacles;
    }

    public final List<Obstacle> getObstacles() {
        return obstacles;
    }

    public final List<Sprite> getSprites() { return sprites; }
}
