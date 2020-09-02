package com.dgyt.cur.volatiletest;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * volatile 不是为了解决线程同步问题，只是写线程写问题的一个限制。
 * 123
 */
public class Test {
    private static volatile int nextSerialNumber = 0;

    public static int generateSerialNumber() {
        return nextSerialNumber++;
    }

    private static Map<Integer, Integer> cache = new ConcurrentHashMap<>(1 << 20);
    public static void main(String[] args) {
        Runnable run = () -> {
            while (true) {
                int val = Test.generateSerialNumber();
                if (cache.containsKey(val)) {
                  //  System.out.println(Thread.currentThread().getName()+"-read"+"-"+val);
                    System.out.println(val);
                    System.exit(0);
                } else {
                   // System.out.println(Thread.currentThread().getName()+"-write"+"-"+val);
                    cache.put(val, val);
                }
            }
        };
        Thread t1 = new Thread(run,"t1");
        Thread t2 = new Thread(run,"t2");
        Thread t3 = new Thread(run,"t3");
        Thread t4 = new Thread(run,"t4");
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}
