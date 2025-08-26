package com.mypractice.datastructure.arrayprograms.algorithm.recursion;

public class FactorialDemo {
    public static void main(String[] args) {
        System.out.println( factorial(5));
    }

    private static int factorial(int no) {
        int fact = 1;
        if (no <= 1){
            return fact;
        }
        return no * factorial(no - 1);
    }
}
