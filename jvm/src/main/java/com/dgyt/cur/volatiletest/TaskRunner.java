package com.dgyt.cur.volatiletest;

public class TaskRunner {
 
    private static int number;
    private static boolean ready;
 
    private static class Reader extends Thread {
 
        @Override
        public void run() {
            while (!ready) {
                Thread.yield();
            }
            System.out.println(number);
        }
    }
 
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        new Reader().start();
        number = 42;
        ready = true;
        Runtime.getRuntime().addShutdownHook(new Thread(()->{
            long end = System.currentTimeMillis();
            System.out.println((end - start));
        }));
    }
}