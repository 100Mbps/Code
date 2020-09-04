package com.dgyt.tank;

import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) {
        final TankFrame frame = new TankFrame("my tank game");
        for(int i=0;i<5;i++){

            frame.tankList.add(new Tank(50*i+50,80,Direction.DOWN,Group.BAD,frame));


        }
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
