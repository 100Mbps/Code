package com.dgyt.tank;

import java.awt.*;

public class MyTank {

    private static final int SPEED = 10;
    private int x = 80;
    private int y = 80;
    private boolean moving;

    Direction direction = Direction.DOWN;
    public MyTank(int x, int y, Direction direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }
    public void paint(Graphics g) {
        switch (direction) {
            case LEFT:
                x -= SPEED;
                break;
            case RIGHT:
                x += SPEED;
                break;
            case UP:
                y -= SPEED;
                break;
            case DOWN:
                y += SPEED;
                break;
        }
        g.fillRect(x, y, 10, 10);
    }

    public boolean isMoving() {
        return moving;
    }

    public void setMoving(boolean moving) {
        this.moving = moving;
    }
}
