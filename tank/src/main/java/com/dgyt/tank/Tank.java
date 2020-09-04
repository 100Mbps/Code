package com.dgyt.tank;

import java.awt.*;

public class Tank {

    private static final int SPEED = 10;
    private int x = 80;
    private int y = 80;
    private boolean moving;
    private final TankFrame tf;
    private static  final int WIDTH = ResourceManager.tankL.getWidth();
    private static  final int HEIGHT = ResourceManager.tankL.getHeight();
    Direction direction;
    public Tank(int x, int y, Direction direction,TankFrame tf) {
        this.x = x;
        this.y = y;
        this.direction = direction;
        this.tf = tf;
    }
    public void paint(Graphics g) {
        switch (direction){
            case LEFT:
                g.drawImage(ResourceManager.tankL,x,y,null);
                break;
            case RIGHT:
                g.drawImage(ResourceManager.tankR,x,y,null);
                break;
            case UP:
                g.drawImage(ResourceManager.tankU,x,y,null);
                break;
            case DOWN:
                g.drawImage(ResourceManager.tankD,x,y,null);
                break;
        }

        move();
    }

    private void move(){
        if(moving) {
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
        }
    }


    public boolean isMoving() {
        return moving;
    }

    public void setMoving(boolean moving) {
        this.moving = moving;
    }

    public void fire() {
      int bx = x + (WIDTH - Bullet.WIDTH)/2;
      int by = y + (HEIGHT - Bullet.HEIGHT)/2;
      tf.bulletList.add(new Bullet(bx,by,this.direction,this.tf));
    }
}
