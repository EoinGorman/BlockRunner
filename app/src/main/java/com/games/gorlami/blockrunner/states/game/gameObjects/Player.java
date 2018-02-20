package com.games.gorlami.blockrunner.states.game.gameObjects;

import android.content.res.Resources;
import android.graphics.RectF;

import common.Collidable;
import common.Constants;
import common.Vector2D;

/**
 * Class representing the player.
 */
public final class Player implements Collidable {
    private static final float JUMP_POWER = -75.0f;
    private boolean onGround;
    private Sprite sprite;
    private Vector2D position;
    private Vector2D velocity;
    private float speed;

    private Player() {
        velocity = new Vector2D(0,0);
    }

    public Player (Resources resources, int resourceId, Vector2D pos) {
        this();
        position = pos;
        sprite = new Sprite(resources, resourceId, position, 0);
    }

    public void update(float deltaTime) {
        if(!onGround) {
            velocity = velocity.getAddResult(
                    Constants.Physics.GRAVITY.getScaleResult(deltaTime * Constants.Physics.SCALE));
        }
        position = position.getAddResult(velocity.getScaleResult(deltaTime * Constants.Physics.SCALE));
        sprite.setPosition(position);
    }

    public void jump() {
        if (onGround) {
            onGround = false;
            velocity.y = JUMP_POWER;
        }
    }

    public final Vector2D getVelocity() {
        return velocity;
    }

    public void setVelocity(final Vector2D newVelocity) {
        velocity = newVelocity;
    }

    public final Sprite getSprite() {
        return sprite;
    }

    @Override
    public void onCollide(Collidable other) {
        if(other.getObjectType() == Constants.Game.ObjectTypes.GROUND) {
            //Player has hit the ground
            if(sprite.getDestRect().bottom > other.getBounds().top) {
                position.y = other.getBounds().top - (sprite.getHeight() /2);
                sprite.setPosition(position);
                velocity.y = 0;
                onGround = true;
            }
        }
    }

    @Override
    public RectF getBounds() {
        return sprite.getDestRect();
    }

    @Override
    public Constants.Game.ObjectTypes getObjectType() {
        return Constants.Game.ObjectTypes.PLAYER;
    }
}
