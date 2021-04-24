package com.mypractice.java8.lamda;

public class ThreadDemo {
    public static void main(String[] args) {
        Runnable runnable = () -> {
            for (int i = 1; i<10; i++){
                System.out.println("child thread" +i);
            }
        };
       Thread thread = new Thread(runnable);
       thread.start();
        for (int i = 1; i<10; i++){
            System.out.println("main thread"+i);
        }
    }
}
