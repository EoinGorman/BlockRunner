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
    private static final float JUMP_POWER = -50.0f;
    private boolean canJump;
    private Sprite sprite;
    private Vector2D position;
    private Vector2D velocity;
    private float speed;

    public Player (Resources resources, int resourceId, Vector2D pos) {
        position = pos;
        velocity = new Vector2D(0,0);
        sprite = new Sprite(resources, resourceId, pos, 0);
    }

    public synchronized void Update(float deltaTime) {
        //Apply gravity if off ground
        if(!canJump) {
            velocity = velocity.getAddResult(Constants.Physics.GRAVITY.getScaleResult(deltaTime));
        }
        position = position.getAddResult(velocity.getScaleResult(deltaTime));
        sprite.setPosition(position);
    }

    public synchronized void Jump() {
        if (canJump) {
            canJump = false;
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
            position.y = other.getBounds().top - 1;
            velocity.y = 0;
            canJump = true;
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
