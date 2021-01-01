package com.dgyt.code.class01;
import static com.dgyt.code.class01.PrintBinary.printBinary;

public class ShiftInt {

    public static void main(String[] args) {

        int a = 10;
        //-a = (~a+1)
        //true
        System.out.println(a == -(~a+1));
        //00000000000000000000000000001010
        printBinary(a);
        printBinary(a<<2);
        printBinary(a>>>2);
        //00111111111111111111111111111101 以0补齐 无符号
        printBinary(-10 >>> 2);
        //11111111111111111111111111111101 以符号位补齐
        printBinary(-10 >> 2);
        //负数的表示非常有意思 为什么正负 Integer的最小值都一样，和负数的表示方法有关系
        //11111111111111111111111111111111
        printBinary(-1);
        //10000000000000000000000000000000
        printBinary(Integer.MIN_VALUE);
        //10000000000000000000000000000000
        printBinary(-Integer.MIN_VALUE);
        System.out.println(Integer.MIN_VALUE + -Integer.MIN_VALUE);




    }




}
