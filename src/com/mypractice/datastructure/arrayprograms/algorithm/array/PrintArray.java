package com.mypractice.datastructure.arrayprograms.algorithm.array;

public class PrintArray {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        printArr(arr, 0);
    }

    private static void printArr(int[] arr, int index) {
        if (arr.length <= index) {
            return;
        }
        System.out.println(arr[index]);
        printArr(arr, index+1);
    }
}
