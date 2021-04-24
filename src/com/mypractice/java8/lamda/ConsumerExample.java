package com.mypractice.java8.lamda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerExample {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("Nasruddin", "Khan");
        Consumer<String> consumer = c -> System.out.println(c);
        list.forEach(consumer);
    }
}
