package com.mypractice.datastructure.arrayprograms.algorithm.recursion;

public class FabinoSeries {
    public static void main(String[] args) {
        /*int a = 0, b = 1;
        int count = 10; // number of Fibonacci numbers to print

        System.out.print(a + " " + b + " ");

        for (int i = 2; i < count; i++) {
            int next = a + b;
            System.out.print(next + " ");
            a = b;
            b = next;
        }*/
        for (int i = 0; i < 10; i++) {
            System.out.print(fibonacci(i)+" ");

        }
    }


    private static int fibonacci(int n) {
        if (n == 0) return 0;            // Base case 1
        if (n == 1) return 1;            // Base case 2
        return fibonacci(n - 1) + fibonacci(n - 2);
    }
}
