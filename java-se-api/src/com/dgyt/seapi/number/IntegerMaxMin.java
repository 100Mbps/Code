package com.dgyt.seapi.number;

/**
 * @author hanrongjie
 * @date 2020/9/10
 */
public class IntegerMaxMin {

    public static void main(String[] args) {
        int min  = 0x80000000; //Integer.MIN_VALUE -2147483648
        int min2 = 0xffffffff;//-1
        int eight = 0x80000008;
        int one = 0x80000001;

        System.out.println(Math.abs(min));
        System.out.println(min2);
        System.out.println(eight);
        System.out.println(eight+min);
        System.out.println(one);
    }
}
