package com.mypractice.java8.stream;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.OptionalInt;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ThirdProgram {

    public static final int MAX = 1000000;

    public static void sortSequential() {
        List<String> values = IntStream.range(0, MAX).mapToObj(s-> UUID.randomUUID().toString()).collect(Collectors.toList());
        long t0 = System.nanoTime();
        long count = values.stream().sorted().count();
        System.out.println(count);
        long t1 = System.nanoTime();
        long millis = TimeUnit.NANOSECONDS.toMillis(t1 - t0);
        System.out.println(String.format("sequential sort took: %d ms", millis));
    }

    public static void sortParallel() {
        List<String> values = IntStream.range(0, MAX).mapToObj(s-> UUID.randomUUID().toString()).collect(Collectors.toList());
        // sequential
        long t0 = System.nanoTime();

        long count = values.parallelStream().sorted().count();
        System.out.println(count);

        long t1 = System.nanoTime();

        long millis = TimeUnit.NANOSECONDS.toMillis(t1 - t0);
        System.out.println(String.format("parallel sort took: %d ms", millis));
    }

    public static void main(String[] args) {
        sortSequential();
        sortParallel();
        for (int i = 0; i < 10; i++) {
            if (i % 2 == 1) {
                System.out.print(i);
            }
        }

        IntStream.range(0, 10).filter(i-> i % 2 == 1).forEach(System.out::print);


        System.out.println("start reduce");
        OptionalInt reduced1 =
                IntStream.range(0, 10)
                        .reduce((a, b) -> a + b);
        System.out.println(reduced1.getAsInt());

        int reduced2 =
                IntStream.range(0, 10)
                        .reduce(7, (a, b) -> a + b);
        System.out.println(reduced2);
        System.out.println("end reduce");

        test1();
        test2();
        test3();
        test4();

    }

    private static void test4() {
        Stream.of(new BigDecimal("1.2"), new BigDecimal("3.7"))
                .mapToDouble(BigDecimal::doubleValue)
                .average()
                .ifPresent(System.out::println);
    }

    private static void test3() {
        IntStream
                .range(0, 10)
                .average()
                .ifPresent(System.out::println);
    }

    private static void test2() {
        IntStream
                .builder()
                .add(1)
                .add(3)
                .add(5)
                .add(7)
                .add(11)
                .build()
                .average()
                .ifPresent(System.out::println);

    }

    private static void test1() {
        int[] ints = {1, 3, 5, 7, 11};
        Arrays.stream(ints)
                .average()
                .ifPresent(System.out::println);
    }
}
