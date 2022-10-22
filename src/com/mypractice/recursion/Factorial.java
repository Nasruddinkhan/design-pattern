package com.mypractice.recursion;

public class Factorial {
    public static void main(String[] args) {
        System.out.println(factorialValue(5));
        System.out.println(fact(5));
    }

    private static int fact(int no) {
        int fact = 1;
        for (int i = 1; i <=no ; i++) {
            fact = fact * i;
        }
        return fact;
    }

    private static int factorialValue(int no) {
        return no==0 ? 1 : no *  factorialValue(no -1);
    }
}
