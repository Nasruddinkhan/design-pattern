package com.mypractice.datastructure.arrayprograms.algorithm.recursion;

public class PowerSeries {
    public static void main(String[] args) {
        int exponent = 5;
        int result = 1;
        int base = 2;
        for (int i = 1; i <=exponent ; i++) {
            result *= base;
        }
        System.out.println(result);
        System.out.println(power(base, exponent));
    }

    private static int power(int base, int exponent) {
        if (exponent == 0) return 1;
        return base * power(base, exponent - 1);
    }
}
