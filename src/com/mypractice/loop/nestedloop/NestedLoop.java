package com.mypractice.loop.nestedloop;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class NestedLoop {
    public static void main(String[] args) {
        int n = 100;
        int m = 0;
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                m = m + 2;
            }
        }

        System.out.println("the constants time " + m);
        // total time = a constant time c * n = cn o(n)
        //Total time =c × n × n = cn 2 = O(n sqr(2))
        AtomicInteger sum = new AtomicInteger();
        int sumValue = IntStream
                .rangeClosed(0, 100)
                .map(e-> IntStream.rangeClosed(0, 100)
                        .map(s -> sum.get() + 2).sum()
                ).sum();
        System.out.println(sumValue);
    }
}
