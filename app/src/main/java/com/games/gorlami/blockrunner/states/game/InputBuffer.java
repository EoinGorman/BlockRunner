package com.games.gorlami.blockrunner.states.game;

import android.view.MotionEvent;

import java.util.Stack;

/**
 * Class to store inputs to be handled in game thread later.
 */
public class InputBuffer {
    private Stack<MotionEvent> touchStack;

    public InputBuffer() {
        touchStack = new Stack<>();
    }

    public synchronized void addToQueue(MotionEvent touch) {
        touchStack.push(touch);
    }

    public MotionEvent getLastTouch() {
        return touchStack.pop();
    }

    public Stack<MotionEvent> getAllTouches() {
        return touchStack;
    }

    public void clearStack() {
        touchStack.clear();
    }
}
