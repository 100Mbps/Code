package com.dgyt.utils;

public class ArrayUtils {
    /**
     * compare two arrays
     *
     * @param arr1 p1
     * @param arr2 p2
     * @return result
     */
    public static boolean compare(int[] arr1, int[] arr2) {
        if (arr1 == null && arr2 == null) {
            return true;
        }
        if (arr1 == null || arr2 == null) {
            return false;
        }
        if (arr1.length != arr2.length) {
            return false;
        }
        int length = arr1.length;
        for (int i = 0; i < length; i++) {
            if (arr1[0] != arr2[0]) {
                return false;
            }
        }
        return true;
    }

    /**
     * is the array sorted
     *
     * @param arr       p1
     * @param orderEnum p2
     * @return result
     */
    public static boolean isSorted(int[] arr, OrderEnum orderEnum) {
        for (int i = 1; i < arr.length; i++) {
            int result = Integer.compare(arr[i], arr[i - 1]);
            if (orderEnum == OrderEnum.ASC && result < 0) {
                return false;
            }
            if (orderEnum == OrderEnum.DES && result > 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean isSortedASC(int[] arr) {
        return isSorted(arr, OrderEnum.ASC);
    }


    public static boolean isSortedDES(int[] arr) {
        return isSorted(arr, OrderEnum.DES);
    }

    public static int[] populateRandomArray(int length, int maxValue) {
        if (length <= 0) {
            throw new IllegalArgumentException("length should be greater than zero");
        }
        if (maxValue < 0) {
            throw new IllegalArgumentException("maxValue should be greater than zero");
        }
        int[] arr = new int[length];
        for (int i = 0; i < length; i++) {
            arr[i] = NumberUtil.populateRandomInteger(maxValue);
        }
        return arr;
    }

    public static int[] copy(int[] arr) {
        if (arr == null) return null;
        int[] copy = new int[arr.length];
        System.arraycopy(arr, 0, copy, 0, arr.length);
        return copy;
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void print(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }
        for (int i : arr) {
            System.out.printf("%d ", i);
        }
        System.out.println();
    }


}
