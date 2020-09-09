package com.dgyt.seapi.collection.map;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hanrongjie
 * @date 2020/9/9
 */
public class MapKey {
    public static void main(String[] args) {
        int cores = Runtime.getRuntime().availableProcessors();
        int numThreadPerCore = 4;
        int threadNum = cores * numThreadPerCore;
        Map<Object,Object> map = new HashMap<>(16);
        Thread[] threads = new Thread[threadNum];
        for(int i=0;i<threadNum;i++){
            threads[i] = new Thread(()->{
                int cnt = 1000000;
                while (cnt-- >0){
                    map.put(new Object(),new Object());
                }
            });
            threads[i].start();
        }


    }
}
