package com.dgyt.code.class01;

import com.dgyt.utils.ArrayUtils;

public class SorterPractice {

    public static void main(String[] args) {
        int[] arr3 = new int[0];
        int[] arr = ArrayUtils.populateRandomArray(10, 10);
        int[] arr2 = ArrayUtils.copy(arr);
        ArrayUtils.print(arr);
        insertSort(arr);
        ArrayUtils.print(arr);
        Sorter.bubbleSort(arr2);
        System.out.println(ArrayUtils.compare(arr, arr2));
//        boolean result =  ArrayUtils.isSortedASC(arr);
//        ArrayUtils.print(arr);
//        System.out.println(result);
    }

    public static void selectionSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[minIndex] > arr[j]) {
                    minIndex = j;
                }
            }
            ArrayUtils.swap(arr, i, minIndex);
        }
    }

    public static void bubbleSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        int end = arr.length - 1;
        for (int i = 0; i < end; i++) {
            for (int j = end; j > i; j--) {
                if (arr[j - 1] > arr[j]) {
                    ArrayUtils.swap(arr, j - 1, j);
                }
            }
        }
    }

    public static void insertSort(int[] arr){
        if (arr == null || arr.length < 2) {
            return;
        }
        for(int i=1;i<arr.length-1;i++){
            for(int curr =i;curr-1 >=0 && arr[curr] < arr[curr-1];curr--){
                    ArrayUtils.swap(arr,curr,curr-1);
            }
        }
    }
}
