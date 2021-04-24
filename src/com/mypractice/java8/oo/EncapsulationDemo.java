package com.mypractice.java8.oo;

public class EncapsulationDemo {
    private int  i = 10;

    @Override
    public String toString() {
        return "EncapsulationDemo{" +
                "i=" + i +
                '}';
    }

    public static void main(String[] args) {
        EncapsulationDemo encapsulationDemo = new EncapsulationDemo();
        encapsulationDemo.i=20;
        System.out.println("encapsulationDemo = " + encapsulationDemo);
    }
}
