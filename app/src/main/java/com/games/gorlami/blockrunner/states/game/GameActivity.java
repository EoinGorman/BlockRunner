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
import com.games.gorlami.blockrunner.states.game.gameObjects.Obstacle;
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
    private static Vector2D SCREEN_CENTER;
    private InputBuffer inputBuffer;
    private CollisionHandler collisionHandler;
    private List<Sprite> sprites;
    private MvcGameView mvcView;
    private Player player;
    private Obstacle testBox;
    private Thread gameThread;
    private GameLoop gameLoop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        gameLoop = new GameLoop(this);
        sprites = new ArrayList<>();
        inputBuffer = new InputBuffer();
        collisionHandler = new CollisionHandler();
        mvcView = new MvcGameViewImpl(LayoutInflater.from(this), null);
        mvcView.setGameListener(this);
        setContentView(mvcView.getRootView());
        SCREEN_CENTER = new Vector2D(getResources().getDisplayMetrics().widthPixels / 2, getResources().getDisplayMetrics().heightPixels / 2);

        //Anonymous Collidable class representing the game "Ground"
        Collidable ground = new Collidable() {
            private RectF bounds = new RectF(0, (SCREEN_CENTER.y * 2) - Constants.Game.FLOOR_HEIGHT_FROM_BOTTOM,
                    SCREEN_CENTER.x * 2, SCREEN_CENTER.y * 4);
            @Override
            public void onCollide(Collidable other) {
                //Do nothing
            }

            @Override
            public RectF getBounds() {
                return bounds;
            }

            @Override
            public Constants.Game.ObjectTypes getObjectType() {
                return Constants.Game.ObjectTypes.GROUND;
            }
        };

        //Create and position a sprite
        player = new Player(getResources(), R.drawable.test, new Vector2D(SCREEN_CENTER.x, ground.getBounds().top - (100/2)));
        testBox = new Obstacle(getResources(), R.drawable.box, new Vector2D((SCREEN_CENTER.x * 2 + 150), ground.getBounds().top - (100/2)), new Vector2D(-1,0));

        sprites.add(player.getSprite());
        sprites.add(testBox.getSprite());
        collisionHandler.attach(player);
        collisionHandler.attach(ground);
        collisionHandler.attach(testBox);

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
        inputBuffer.addToQueue(event);
        return true;
    }

    @Override
    public void Update(float deltaTime) {
        handleInputs();
        player.update(deltaTime);
        testBox.update(deltaTime);
        collisionHandler.checkCollisions();
    }

    @Override
    public void Draw() {
        mvcView.drawOnNextUpdate(sprites);
    }

    private void handleInputs() {
        synchronized (inputBuffer) {
            while(!inputBuffer.getAllTouches().isEmpty()) {
                MotionEvent lastTouch = inputBuffer.getLastTouch();
                if(lastTouch.getAction() == MotionEvent.ACTION_DOWN) {
                    player.jump();
                }
                else if(lastTouch.getAction() == MotionEvent.ACTION_UP) {
                    player.endJump();
                }
            }
        }
    }
}
