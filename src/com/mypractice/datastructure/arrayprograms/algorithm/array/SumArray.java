package com.mypractice.datastructure.arrayprograms.algorithm.array;

public class SumArray {
    public static void main(String[] args) {
        int[] arr = {5, 10, 15, 20};
        int sum = 0;
        for (int num : arr) sum += num;
        System.out.println("Sum: " + sum);
        int sumArry = sumArray(arr, 0, 0);
        System.out.println("sum = "+ sumArry);
        int sumA = sumArray(arr, 0);
        System.out.println("sum = "+ sumA);
    }

    private static int sumArray(int[] arr, int index, int sum) {
        if (arr.length == index) return sum;
        sum = sum + arr [index];
        return sumArray(arr, index + 1, sum);
    }

    private static int sumArray(int[] arr, int index) {
        if (arr.length == index) return 0;
        return arr[index] + sumArray(arr, index + 1);
    }
}
