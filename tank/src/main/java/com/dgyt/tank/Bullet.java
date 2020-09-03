package com.dgyt.tank;

import java.awt.*;

public class Bullet {

    private static final int SPEED = 4;
    private int x = 80;
    private int y = 80;
    Direction direction = Direction.DOWN;

    public Bullet(int x, int y, Direction direction) {
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
        Color orignalColor = g.getColor();
        g.setColor(Color.red);
        g.fillOval(x, y, 5, 5);
        g.setColor(orignalColor);
    }

}
