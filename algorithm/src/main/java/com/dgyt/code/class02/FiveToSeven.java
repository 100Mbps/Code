package com.dgyt.code.class02;

import com.dgyt.code.class01.PrintBinary;

import java.util.SortedMap;
import java.util.TreeMap;

/**
 * 有一个黑盒方法等概率产生1-5
 * 目标方法等概率产生1-7
 * <p>
 * 1.思路
 */
public class FiveToSeven {

    public static void main(String[] args) {
        int testTimes = 10000000;
        int numCnt = 7;
        int[] arr =new int[numCnt];
        for(int i=0;i<testTimes;i++){
            int tmp = generateSeven();
            arr[tmp-1]++;
        }
        for (int j = 0;j<numCnt;j++){
            System.out.printf("%d 出现了 %d 次%n",(j+1),arr[j]);
        }
    }
    //等概率产生1-5
    public static int generateFive() {
        return Random.generateInteger(5);
    }

    /**
     * 等概率产生 0,1
     *
     * @return 0 or 1
     */
    public static int generateZeroAndOne() {
        int ans;
        do {
            ans = generateFive();
            if (ans < 3) {
                return 0;
            } else if (ans > 3)
                return 1;
        } while (true);
    }
    public static int generateSeven() {
        int ans;
        do {
            //注意位运算加括号，否则会从左到右依次运算运算
            //eg. 1+2<<1 =3 << 1=6
            //eg  1+(2<<1) = 5
            ans = (generateZeroAndOne() << 2) + (generateZeroAndOne() << 1) + generateZeroAndOne();
            if (ans != 7) return ans+1;
        } while (true);
    }
}
