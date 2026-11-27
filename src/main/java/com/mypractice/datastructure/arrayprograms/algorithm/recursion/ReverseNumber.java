package com.mypractice.datastructure.arrayprograms.algorithm.recursion;

import javax.swing.plaf.synth.SynthOptionPaneUI;

public class ReverseNumber {
    public static void main(String[] args) {
        int number = 12345, reversed = 0;

        while (number != 0) {
            int digit = number % 10;
            reversed = reversed * 10 + digit;
            number /= 10;
        }

        System.out.println("Reversed: " + reversed); // 54321

        int revers = reversed(12345, 0);
        System.out.println(revers);
    }

    private static int reversed(int number, int rev) {
        if (number == 0) return rev;
        int digit = number % 10;
        return reversed(number/10,   rev * 10 + digit);

    }
}
