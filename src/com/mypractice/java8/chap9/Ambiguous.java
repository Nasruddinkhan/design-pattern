package com.mypractice.java8.chap9;

public class Ambiguous{

    public static void main(String... args) {
        new C().hello();
    }

    interface A{
        default void hello() {
            System.out.println("Hello from A");
        }
    }

    interface B {
        default void hello() {
            System.out.println("Hello from B");
        }
    }

    static class C implements B, A {
        public void hello(){
            A.super.hello();
        }
    }
}
