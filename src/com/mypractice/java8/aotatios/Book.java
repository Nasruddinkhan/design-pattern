package com.mypractice.java8.aotatios;

import java.util.Arrays;

@Author(name = "Nasruddin")
@Author(name = "Rehan")
@Author(name = "Jalaluddin")
public class Book {

    public static void main(String[] args) {
        Author[] authors = Book.class.getAnnotationsByType(Author.class);
        Arrays.asList(authors).stream().forEach(a -> {
            System.out.println(a.name());
        });
    }

}
