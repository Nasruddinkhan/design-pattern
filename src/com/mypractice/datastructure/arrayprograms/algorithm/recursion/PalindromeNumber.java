package com.mypractice.datastructure.arrayprograms.algorithm.recursion;

public class PalindromeNumber {
    public static void main(String[] args) {
        int number = 121;
        int original = number;
        int reversed = 0;

        while (number != 0) {
            int digit = number % 10;
            reversed = reversed * 10 + digit;
            number /= 10;
        }

        System.out.println("Is palindrome? " + (original == reversed));
        int no = 123213;
        boolean isPlinDrom =  isPalinDrom(no, 0) == no;
        System.out.println("isPlinDrom ? "+ isPlinDrom);

    }

    private static int isPalinDrom(int no, int reverse) {
        if (no == 0) return reverse;
        int digit =  no % 10;
        return isPalinDrom(no/10 , reverse * 10 + digit);

    }
}
