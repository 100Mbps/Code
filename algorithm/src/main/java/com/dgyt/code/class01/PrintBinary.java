package com.dgyt.code.class01;

/**
 * print int binary
 */
public class PrintBinary {

    public static void printBinary(int num) {
        for (int i = 31; i >= 0; i--) {
            System.out.print((1 << i & num) == 0 ? "0" : "1");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        printBinary(2);
    }
}
