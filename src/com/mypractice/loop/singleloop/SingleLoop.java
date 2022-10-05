package com.mypractice.loop.singleloop;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class SingleLoop {
    public static void main(String[] args) {
        int n = 100;
        int m = 0;
        for (int i = 0; i <= n; i++) m = m + 2;
        System.out.println("the constants time " + m);
        // total time = a constant time c * n = cn o(n)
        AtomicInteger sum = new AtomicInteger();
        int sumValue = IntStream.rangeClosed(0, 100).map(s-> sum.get() +2).sum();
        System.out.println(sumValue);
        startPrint(10);
        countFunction(10);

    }

    private static void countFunction(int n) {
        int i= 0;
        int count = 0;
        for ( i = 1; i*i <=n ; i++) {
            count++;
        }
        System.out.println("count "+count);
    }

    public static void startPrint(int n) {
        int i = 1;
        int s =1;
        while (s <=n){
            i++;
            s=s+i;
            System.out.println("*");
        }
    }
}
