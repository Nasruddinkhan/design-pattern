package com.mypractice.java8.lamda;

import java.util.Comparator;

@FunctionalInterface
public interface MyComparator {
    void display();
    boolean equals(Object obj);
}
