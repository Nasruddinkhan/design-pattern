package com.mypractice.java8.lamda;

import java.util.Comparator;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.Callable;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * Common standard functions from the Java API.
 *
 * @author Benjamin Winterberg
 */
public class Lambda3 {

    @FunctionalInterface
    interface Fun {
        void foo();
    }

    public static void main(String[] args) throws Exception {

        // Predicates

        Predicate<String> predicate = (s) -> s.length() > 0;

        System.out.println( predicate.test("Nasruddin"));              // true
        System.out.println( predicate.negate().test("khan"));;  // false

        Predicate<Boolean> nonNull = Objects::nonNull;
        Predicate<Boolean> isNull = Objects::isNull;

        Predicate<String> isEmpty = String::isEmpty;
        Predicate<String> isNotEmpty = isEmpty.negate();


        // Functions

        Function<String, Integer> toInteger = Integer::valueOf;
        Function<String, String> backToString = toInteger.andThen(String::valueOf);

        System.out.println(  backToString.apply("123"));     // "123"


        // Suppliers

        Supplier<Person> personSupplier = Person::new;
        System.out.println(personSupplier.get());   // new Person


        // Consumers

        Consumer<Person> greeter = (p) -> System.out.println("Hello, " + p.firstName);
        greeter.accept(new Person("Nasruddin", "khan"));



        // Comparators

        Comparator<Person> comparator = (p1, p2) -> p1.firstName.compareTo(p2.firstName);

        Person p1 = new Person("Nasruddin", "khan");
        Person p2 = new Person("Rehan", "Shaikh");

        comparator.compare(p1, p2);             // > 0
        comparator.reversed().compare(p1, p2);  // < 0


        // Runnables

        Runnable runnable = () -> System.out.println("runnable "+ UUID.randomUUID());
        runnable.run();


        // Callables
        Callable<UUID> callable = UUID::randomUUID;
        System.out.println("callable ["+ callable.call()+"]");
    }

}
