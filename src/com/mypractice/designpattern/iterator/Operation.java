package com.mypractice.designpattern.iterator;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class Operation {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 12, 13);
        System.out.println(totalValues(numbers));
        System.out.println(totalEvenValues(numbers));
        System.out.println(totalOddValues(numbers));

        System.out.println(totalValues(numbers, no->true));
        System.out.println(totalValues(numbers, no->no%2 == 0));
        System.out.println(totalValues(numbers, Operation::isOdd));


    }

    public static boolean isOdd(int no){
        return  no%2 != 0;
    }
    private static int totalOddValues(List<Integer> numbers) {
        int toatal = 0;
        for (Integer no : numbers) {
            if (no % 2 != 0)
                toatal += no;
        }
        return toatal;
    }

    private static int totalEvenValues(List<Integer> numbers) {
        int toatal = 0;
        for (Integer no : numbers) {
            if (no % 2 == 0)
                toatal += no;
        }
        return toatal;
    }

    private static int totalValues(List<Integer> numbers) {
        int toatal = 0;
        for (Integer no : numbers) {
            toatal += no;
        }
        return toatal;
    }

    private static int totalValues(List<Integer> numbers, Predicate<Integer> selector) {
        return numbers.stream().filter(selector).reduce(0, Integer::sum);
    }
}
