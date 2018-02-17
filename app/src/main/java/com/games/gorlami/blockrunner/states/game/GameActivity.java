/*
 ****************************************
 * Created by Eoin Gorman on 06/02/2018.
 ****************************************
 */

package com.games.gorlami.blockrunner.states.game;

import android.app.Activity;
import android.graphics.RectF;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;

import com.games.gorlami.blockrunner.R;
import com.games.gorlami.blockrunner.states.game.gameObjects.Player;
import com.games.gorlami.blockrunner.states.game.gameObjects.Sprite;
import com.games.gorlami.blockrunner.states.game.view.MvcGameView;
import com.games.gorlami.blockrunner.states.game.view.MvcGameViewImpl;

import java.util.ArrayList;
import java.util.List;

import common.Collidable;
import common.CollisionHandler;
import common.Constants;
import common.Vector2D;

/**
 * Activity that represents the game screen.
 */
public final class GameActivity extends Activity implements GamePresenter {
    private CollisionHandler collisionHandler;
    private List<Sprite> sprites;
    private MvcGameView mvcView;
    private Player player;
    private Thread gameThread;
    private GameLoop gameLoop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        gameLoop = new GameLoop(this);
        sprites = new ArrayList<>();
        collisionHandler = new CollisionHandler();
        mvcView = new MvcGameViewImpl(LayoutInflater.from(this), null);
        mvcView.setGameListener(this);
        setContentView(mvcView.getRootView());

        //Anonymous Collidable class representing the game "Ground"
        Collidable ground = new Collidable() {
            @Override
            public void onCollide(Collidable other) {
                //Do nothing
            }

            @Override
            public RectF getBounds() {
                return new RectF(0, Constants.Game.FLOOR_HEIGHT,
                        getResources().getDisplayMetrics().widthPixels, getResources().getDisplayMetrics().heightPixels);
            }

            @Override
            public Constants.Game.ObjectTypes getObjectType() {
                return Constants.Game.ObjectTypes.GROUND;
            }
        };

        //Create and position a sprite
        player = new Player(getResources(), R.drawable.test, new Vector2D(250, Constants.Game.FLOOR_HEIGHT));

        sprites.add(player.getSprite());
        collisionHandler.checkOnNextUpdate(player);
        collisionHandler.checkOnNextUpdate(ground);

        gameThread = new Thread(gameLoop);
        gameThread.start();
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        gameLoop.terminate();
        try {
            gameThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean onScreenTouched(View view, MotionEvent event) {
        if(event.getAction() == MotionEvent.ACTION_DOWN) {
            player.Jump();
            return true;
        }
        return false;
    }

    @Override
    public void Update(float deltaTime) {
        //todo add some kind of InputHandler that will deal with touches etc. in the main thread.
        player.Update(deltaTime);
        collisionHandler.checkCollisions();
    }

    @Override
    public void Draw() {
        mvcView.drawOnNextUpdate(sprites);
    }
}
