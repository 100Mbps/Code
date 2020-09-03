package com.dgyt.tank;

import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) {
        final TankFrame frame = new TankFrame("my tank game");
        new Thread(()->{
            while (true){
                try {
                    TimeUnit.MILLISECONDS.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                frame.repaint();
            }
        }).start();
    }


}
