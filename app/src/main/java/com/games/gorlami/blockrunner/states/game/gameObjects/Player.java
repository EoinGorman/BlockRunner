package com.games.gorlami.blockrunner.states.game.gameObjects;

import android.content.res.Resources;
import android.graphics.RectF;
import android.util.Log;

import common.Collidable;
import common.Constants;
import common.Vector2D;

/**
 * Class representing the player.
 */
public final class Player implements Collidable {
    private static final float JUMP_POWER = -55.0f;
    private static final float EXTENDED_JUMP_POWER = -(Constants.Physics.GRAVITY.y/2.0f);
    private boolean onGround;
    private boolean jumping;
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
            velocity.y += Constants.Physics.GRAVITY.y * deltaTime * Constants.Physics.SCALE;
        }
        if(jumping) {
            velocity.y += EXTENDED_JUMP_POWER * deltaTime * Constants.Physics.SCALE;
            if(velocity.y >= -0.1f) {
                jumping = false;
            }
        }
        position = position.getAddResult(velocity.getScaleResult(deltaTime * Constants.Physics.SCALE));
        sprite.setPosition(position);
    }

    public void jump() {
        if (onGround) {
            onGround = false;
            jumping = true;
            velocity.y = JUMP_POWER;
        }
    }

    public void endJump() {
        jumping = false;
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
