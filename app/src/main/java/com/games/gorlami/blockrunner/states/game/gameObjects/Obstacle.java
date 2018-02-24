package com.games.gorlami.blockrunner.states.game.gameObjects;

import android.graphics.RectF;

import com.games.gorlami.blockrunner.states.ResourceLoader;

import common.Collidable;
import common.Constants;
import common.Vector2D;

/**
 * Scrolling obstacle object that player must avoid.
 */
public class Obstacle implements Collidable {
    private Sprite sprite;
    private Vector2D position;
    private Vector2D velocity;
    private float speed;

    public Obstacle(Vector2D pos, Vector2D startingVelocity) {
        speed = 10;
        position = pos;
        velocity = startingVelocity;
        sprite = new Sprite(ResourceLoader.BOX_BITMAP, position, 0);
    }

    public void update(float deltaTime) {
        position = position.getAddResult(velocity.getScaleResult(deltaTime * Constants.Physics.SCALE * speed));
        sprite.setPosition(position);
    }

    public final Sprite getSprite() {
        return sprite;
    }

    @Override
    public void onCollide(Collidable other) {
        //Doesn't do anything fun.
        //Collision with player will be handled there.
    }

    @Override
    public RectF getBounds() {
        return sprite.getDestRect();
    }

    @Override
    public Constants.Game.ObjectTypes getObjectType() {
        return Constants.Game.ObjectTypes.OBSTACLE;
    }
}
