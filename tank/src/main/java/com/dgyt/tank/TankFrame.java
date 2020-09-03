package com.dgyt.tank;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


public class TankFrame extends Frame {
    private final  MyTank myTank = new MyTank(80,80,Direction.DOWN);
    public TankFrame(String name) {
        super.setVisible(true);
        super.setResizable(true);
        super.setName(name);
        super.setTitle(name);
        super.setSize(800, 800);
        super.addWindowListener(new WindowAdapter() {
            // close frame
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        super.addKeyListener(new MyKeyListener());
    }

    @Override
    public void paint(Graphics g) {
          myTank.paint(g);
    }

    class MyKeyListener implements KeyListener {
        // 如果同时按两个键怎么处理
        //up
        private boolean bU = false;
        //Down
        private boolean bD = false;
        //Left
        private boolean bL = false;
        //Right
        private boolean bR = false;


        public void keyTyped(KeyEvent e) {

        }
        public void keyPressed(KeyEvent e) {
            // 39 ->
            int keyCode = e.getKeyCode();
            switch (keyCode) {
                case KeyEvent.VK_LEFT:
                    bL = true;
                    break;
                case KeyEvent.VK_RIGHT:
                    bR = true;
                    break;
                case KeyEvent.VK_UP:
                    bU = true;
                    break;
                case KeyEvent.VK_DOWN:
                    bD = true;
                    break;
                default:
                    break;
            }
            setMainDirection();
        }
        public void keyReleased(KeyEvent e) {
            int keyCode = e.getKeyCode();
            switch (keyCode) {
                case KeyEvent.VK_LEFT:
                    bL = false;
                    break;
                case KeyEvent.VK_RIGHT:
                    bR = false;
                    break;
                case KeyEvent.VK_UP:
                    bU = false;
                    break;
                case KeyEvent.VK_DOWN:
                    bD = false;
                    break;
                default:
                    break;
            }
            setMainDirection();
        }
        private void setMainDirection(){
           if(!bL && !bR && !bU && !bD){
               myTank.setMoving(false);
           }else{
               if(bL) myTank.direction = Direction.LEFT;
               if(bR) myTank.direction = Direction.RIGHT;
               if(bU) myTank.direction = Direction.UP;
               if(bD) myTank.direction = Direction.DOWN;
               myTank.setMoving(true);
           }
         }
    }


}


