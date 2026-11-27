package com.mypractice.java8.declaretion;

public class TestDays {
    public enum Days{
        MON, TUE, WED, THU, FRI, SAT, SUN;
    }
    public static void main(String[] args) {
        for (Days d: Days.values());
        Days []days = Days.values();
        System.out.println("days[2] = " + days[2]);
    }
}
