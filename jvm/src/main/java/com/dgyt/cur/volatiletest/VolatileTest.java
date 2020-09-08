package com.dgyt.cur.volatiletest;

import java.util.concurrent.TimeUnit;

/**
 * @author hanrongjie
 * @date 2020/9/8
 */
public class VolatileTest {
    public static volatile int race=0;

    public static int increase(){
        return  race++;
    }




    public static void main(String[] args) throws InterruptedException {
        int threadNum = Runtime.getRuntime().availableProcessors()*4;
        int loop = 10000;
        Thread[] threads = new Thread[threadNum];
        for (int i=0;i<threadNum;i++ ){
            threads[i] = new Thread(()->{
                for (int j = 0;j< loop; j++){
                    increase();
                }
            });
            threads[i].start();
        }
        // while 的条件 >1 和 > 2还不一定。需要深究。
        while(Thread.activeCount() > 2){
            //打印当前thread group 下的所有线程信息
            Thread.currentThread().getThreadGroup().list();
            TimeUnit.SECONDS.sleep(1);
            Thread.yield();
        }
        int expect = threadNum * loop;
        System.out.printf("expect [%d],actual [%d]",expect,race);
    }
}
