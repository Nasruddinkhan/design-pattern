package com.mypractice.loop.consecutive;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class NestedLoop {
    public static void main(String[] args) {
        int n = 100;
        int m = 0;
        int l = 0;
        int k = 0;
        for (int i = 0; i <= n; i++) {
            m = m + 2;
            for (int j = 0; j <= n; j++) {
                for (l = 0; l <= n; l++) {
                    k = k + 1;
                }
            }
        }
        System.out.println(m);
        System.out.println(k);
        AtomicInteger xatomic = new AtomicInteger();
        AtomicInteger sum = new AtomicInteger();
        int sumValue = IntStream.rangeClosed(0, 100).map(x -> sum.get() + 2)
                        .map(x -> IntStream.rangeClosed(0, 100)
                        .map(e -> IntStream.rangeClosed(0, 100).map(s -> xatomic.get() + 1).sum()).sum()).sum();
        System.out.println(sumValue);


    }
}
