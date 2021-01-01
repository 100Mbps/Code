package com.dgyt.leetcode.problems;

import javafx.util.Pair;

import java.util.*;

/**
 * https://leetcode.com/problems/least-number-of-unique-integers-after-k-removals/
 */
public class LeastNumOfUnique {
    public static void main(String[] args) {
        int[] arr = {9,17,11,19,4,22,27,15,24,30,45,11,17,37,37};
        int left = findLeastNumOfUniqueInts(arr,8);
        System.out.println(left);
    }

    public static  int findLeastNumOfUniqueInts(int[] arr, int k) {
        if(arr.length <=k) return 0;
        Map<Integer,Integer> map = new HashMap<>();
        for (int curr : arr) {
            map.put(curr, map.getOrDefault(curr,0)+1);
        }
        PriorityQueue<Element> sorted = new PriorityQueue<>(Comparator.comparingInt(o -> o.count));
        for(int key: map.keySet()){
            Element ele = new Element();
            ele.key = key;
            ele.count = map.get(key);
            sorted.offer(ele);
        }
        int remove = 0;
        while(!sorted.isEmpty()){
            Element tmp = sorted.poll();
            remove += tmp.count;
            if(remove <=k){
                map.remove(tmp.key);
            } else{
                break;
            }
        }
       return map.keySet().size();
    }

    /**
     * Pair<Integer,Integer> replace Element class
     * @param arr
     * @param k
     * @return
     */
    public static  int findLeastNumOfUniqueIntsPair(int[] arr, int k) {
        if(arr.length <=k) return 0;
        Map<Integer,Integer> map = new HashMap<>();
        for (int curr : arr) {
            map.put(curr, map.getOrDefault(curr,0)+1);
        }
        PriorityQueue<Pair<Integer,Integer>> sorted = new PriorityQueue<>(Comparator.comparingInt(Pair::getValue));
        for(int key: map.keySet()){

            int count = map.get(key);
            sorted.offer(new Pair<>(key,count));
        }
        int remove = 0;
        while(!sorted.isEmpty()){
            Pair<Integer,Integer> tmp = sorted.poll();
            remove += tmp.getValue();
            if(remove <=k){
                map.remove(tmp.getKey());
            } else{
                break;
            }
        }
        return map.keySet().size();
    }

    /**
     * slower than
     * @see LeastNumOfUnique#findLeastNumOfUniqueInts
     * @param arr int array
     * @param k cnt
     * @return number
     */
    public static  int findLeastNumOfUniqueIntsOther(int[] arr, int k){
        if(arr.length <=k) return 0;
        Map<Integer,Integer> map = new HashMap<>();
        for (int curr : arr) {
            map.put(curr, map.getOrDefault(curr,0)+1);
        }
        // 慢在比较方法，每次都需要去map里取数
        PriorityQueue<Integer> sorted = new PriorityQueue<>(Comparator.comparingInt(map::get));
        for(int num: map.keySet()){
            sorted.offer(num);
        }
        while(!sorted.isEmpty() && k >0){
            k -= map.get(sorted.peek());
            if(k > 0 ){
                sorted.poll();
            }else{
                break;
            }
        }
        return sorted.size();
    }






}
class Element{
     int key;
     int count;

    @Override
    public String toString() {
        return "Element{" +
                "key=" + key +
                ", count=" + count +
                '}';
    }
}
