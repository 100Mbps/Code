package com.dgyt.tank;

import java.awt.*;

public class Bullet {

    private static final int SPEED = 4;
    private int x = 80;
    private int y = 80;
    private TankFrame tankFrame;
    private boolean alive = true;

    Direction direction = Direction.DOWN;

    public Bullet(int x, int y, Direction direction,TankFrame tankFrame) {
        this.x = x;
        this.y = y;
        this.direction = direction;
        this.tankFrame = tankFrame;
    }

    public void paint(Graphics g) {
        move();
        if(alive) {
            Color originalColor = g.getColor();
            g.setColor(Color.red);
            g.fillOval(x, y, 10, 10);
            g.setColor(originalColor);
        }else{
            tankFrame.bulletList.remove(this);
        }

    }
    private void move(){
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
        this.setAlive();
    }


    private void setAlive(){
       if(x <0 || y <0 ||x > TankFrame.GAME_WIDTH || y < TankFrame.GAME_HEIGHT){
           this.alive =false;
       }
    }
}
