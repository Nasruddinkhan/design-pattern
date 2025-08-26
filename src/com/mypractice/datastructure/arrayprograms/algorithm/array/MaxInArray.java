package com.mypractice.datastructure.arrayprograms.algorithm.array;

public class MaxInArray {
    public static void main(String[] args) {
        int[] arr = {10, 20, 5, 40, 25};
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max){
                max = arr[i];
            }
        }
        System.out.println(max);

        int[] no = {10, 20, 5, 40, 25};
        System.out.println(maxNumber(no, 0, no[0]));    }
    public static int maxNumber(int arr[], int index, int max){
        if (arr.length == index ) return max;
          if (arr[index] > max) max = arr[index];
        return maxNumber(arr, index+1, max);
    }
}
