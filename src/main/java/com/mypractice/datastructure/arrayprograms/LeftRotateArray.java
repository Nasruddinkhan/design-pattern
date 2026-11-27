package com.mypractice.datastructure.arrayprograms;

import java.util.Scanner;

public class LeftRotateArray {
    //initialize array
    static int[] initializeArray(int size, Scanner scanner) {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++)
            arr[i] = scanner.nextInt();
        return arr;
    }
    //printing array
    static void printArray(int []arr){
        System.out.println("array printing start");
        for (int a:arr)
            System.out.print(a+" ");
        System.out.println("array printing end");
    }
    static void leftRotation(int[] arr, int size, int lfSize){
        for (int i=0; i<lfSize;i++)
            leftRotationOneByOne(arr, size);
    }
    static void leftRotationOneByOne( int []arr, int size){
        int i;
        int temp = arr[0];
        for (i=0;i<size-1;i++)
            arr[i] = arr[i+1];
        arr[i] = temp;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the array length");
        int arrSize = scanner.nextInt();
        System.out.println("initialize array ");
        int []arr = initializeArray(arrSize, scanner);
        printArray(arr);
        System.out.println("pass left rotation size ");
        int lfSize = scanner.nextInt();
        if(lfSize >=arrSize)
            throw  new RuntimeException("left rotation size should be less then for array size");
        leftRotation(arr, arrSize, lfSize);
        printArray(arr);
    }
}

