package com.mypractice.datastructure.arrayprograms.algorithm.recursion;

public class CountDigits {
    public static void main(String[] args) {
        int number = 12345;
        int count = 0;

        if (number == 0) count = 1;
        else {
            while (number != 0) {
                number /= 10;
                count++;
            }
        }

        System.out.println("Total digits: " + count); // Output: 5
        System.out.println(countDigit(45677, 0));
    }

    private static int countDigit(int number, int count) {
        if (number <= 0) return count;
        return countDigit(number / 10, count+1);
    }
}
