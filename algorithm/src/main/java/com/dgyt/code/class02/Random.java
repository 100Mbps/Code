package com.dgyt.code.class02;

public class Random {
    public static void main(String[] args) {
        // [0,1) 等概率
        double randomNum =  Math.random();
        int testTimes = 10000;
        //int count = 0;
        int[] arr =new int[5];
        for(int i=0;i<testTimes;i++){
            arr[generateInteger(5)-1]++;
        }
        for (int j = 0;j<5;j++){
            System.out.printf("%d 出现了 %d 次%n",(j+1),arr[j]);
        }
    }

    /**
     * 等概率产生 [1,maxValue]
     * @param maxValue max value
     * @return result
     */
    public static int  generateInteger(int maxValue){
       return (int)(Math.random()*maxValue+1);
    }


}
