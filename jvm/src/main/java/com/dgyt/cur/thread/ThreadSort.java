package com.dgyt.cur.thread;

import java.util.concurrent.TimeUnit;

public class ThreadSort {

    public static void main(String[] args) {
        int[] arr = {2, 3, 6, 9, 10};
        for (int i : arr) {
            new Thread(() -> {
                try {
                    TimeUnit.SECONDS.sleep(i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(i);
            }).start();
        }
    }
}
