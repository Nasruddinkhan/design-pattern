package com.mypractice.java8.stream;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class FirstProgram {
    public static void main(String[] args) {

        List<String> names = new ArrayList<>();
        names.add("Nasruddin khan");
        names.add("Jalauddin khan");
        names.add("Rehan Shaikh");
        names.add("Najmul khan");
        names.add("Fazlurrehman");
        names.add("Zubair khan");
        names.add("Krishna");
        names.add("Mahmood");

        System.out.println("filter example start");
        names.stream().filter((s) -> s.startsWith("N")).forEach(System.out::println);
        System.out.println("filter example end");


        System.out.println("sorted example start");
        names.stream()
            .sorted()
            .filter((s) -> s.startsWith("N"))
            .forEach(System.out::println);
        names.stream()
                .map(String::toUpperCase)
                .sorted(Comparator.reverseOrder()) //(a, b) -> b.compareTo(a)
                .forEach(System.out::println);
        System.out.println("sorted example end");



        System.out.println("matching example start");
        boolean anyStartsWithF = names
                .stream()
                .anyMatch((s) -> s.startsWith("F"));

        System.out.println(anyStartsWithF);      // true
        System.out.println("matching example end");

        boolean allStartsWithN= names
                .stream()
                .allMatch((s) -> s.startsWith("N"));

        System.out.println(allStartsWithN);      // false

        boolean noneStartsWithZ = names
                .stream()
                .noneMatch((s) -> s.startsWith("Z")); // false

        System.out.println(noneStartsWithZ);
        boolean noneStartsWithQ = names
                .stream()
                .noneMatch((s) -> s.startsWith("Q"));

        System.out.println(noneStartsWithQ);      // true

        // counting

        long startsWithK = names
                .stream()
                .filter((s) -> s.startsWith("K"))
                .count();

        System.out.println(startsWithK);

        System.out.println("reducing example start");
        // reducing | seprator
        Optional<String> reduced =
                names
                        .stream()
                        .sorted()
                        .reduce((s1, s2) -> s1 + " | " + s2);

        reduced.ifPresent(System.out::println);
        System.out.println("reducing example end");

    }
}