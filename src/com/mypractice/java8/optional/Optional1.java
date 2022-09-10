package com.mypractice.java8.optional;

import java.util.Optional;


public class Optional1 {

    public static void main(String[] args) {
        Optional<String> optional = Optional.ofNullable(null);
        System.out.println( optional.isPresent());           // true
       // System.out.println(optional.get());                 // "Nasruddin"
      //  System.out.println(optional.orElse("fallback"));    // "Nasruddin"
        optional.ifPresent((s) -> System.out.println(s.charAt(0)));     // "N"
    }

}