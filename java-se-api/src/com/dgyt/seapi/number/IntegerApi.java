package com.dgyt.seapi.number;

import java.util.ArrayList;
import java.util.List;

public class IntegerApi {

    public static void main(String[] args) {
        int high = Integer.highestOneBit(10);
        System.out.println(IntegerApi.log2(high));
        int[] arr = {3, 3, 4, 4, 5, 56};
        int xor = 0;
        for (int num : arr) {
            xor ^= num;
        }
        high = Integer.lowestOneBit(xor);
        List<Integer> sameHigh = new ArrayList<>();
        for (int num : arr) {
            if (Integer.lowestOneBit(num) == high) {
                sameHigh.add(num);
            }
        }
        int xor1 = 0;
        for (int num : sameHigh) {
            xor1 ^= num;
        }
        int first =  xor1;
        int second = xor ^ first;
        System.out.println(first);
        System.out.println(second);
    }


    public static int log2(int N) {

        // calculate log2 N indirectly
        // using log() method
        return  (int) (Math.log(N) / Math.log(2));

    }


}
