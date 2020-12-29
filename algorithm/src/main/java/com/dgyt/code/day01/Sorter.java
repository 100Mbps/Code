package com.dgyt.code.day01;

public class Sorter {

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void print(int[] arr){
        for (int j : arr) {
            System.out.print(j + " ");
        }
        System.out.println();
    }

    /**
     * 1.首先要进行边界检测
     * 选择排序是找到最小放到对应的位置
     * @param arr sorted array
     */
    public static void selectionSort(int[] arr){
        if(arr == null || arr.length<2) {
            return;
        }
        for(int i=0;i<arr.length-1;i++){
            int minIndex = i;
            for(int j=i+1;j<arr.length;j++){
                 if(arr[j] < arr[minIndex]){
                     minIndex = j;
                 }
            }
            swap(arr,i,minIndex);
        }
    }

    /**
     * bubbleSort
     * @param arr sorted array
     */
    public static void bubbleSort(int[] arr){
        if(arr == null || arr.length<2) {
            return;
        }
        int end = arr.length-1;
        //将最大数一次转移到最右
        for(int i=end;i>=1;i--){
            for(int j=1;j<=i;j++){
                if(arr[j-1]>arr[j]){
                    swap(arr,j,j-1);
                }
            }
        }
    }

    /**
     * while implementation
     * @param arr sorted array
     */
    public static void insertSort(int[] arr){
        if(arr == null || arr.length<2) {
            return;
        }
        int end = arr.length-1;
        for(int i=1; i <=end;i++){
            int currentIndex = i;
            while(currentIndex-1>=0 && arr[currentIndex-1]>arr[currentIndex]){
                swap(arr,currentIndex,currentIndex-1);
                currentIndex--;
            }
        }
    }

    /**
     *
     * @param arr sorted array
     */
  public static void insertSortV2(int[] arr){
      if(arr == null || arr.length<2) {
          return;
      }
      int end = arr.length-1;
      for(int i=1;i<=end;i++){
          for(int current = i;current-1>=0 && arr[current-1]>arr[current];current--){
              swap(arr,current,current-1);
          }
      }
 }




    public static void main(String[] args) {
        int[] arr = {1,5,3,2,4,5,3,6,5,43,5,4,3};
        print(arr);
        //selectionSort(arr);
        //bubbleSort(arr);
        insertSortV2(arr);
        print(arr);
    }





}
