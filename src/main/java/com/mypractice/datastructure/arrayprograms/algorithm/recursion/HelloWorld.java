package com.mypractice.datastructure.arrayprograms.algorithm.recursion;

public class HelloWorld {

    public void displayName(int no){
        if (no <= 0){
            return;
        }
        System.out.println("Nasruddin khan "+ no);
        displayName(no-1);
    }
    public static void main(String[] args) {
        System.out.println("Main");
        new HelloWorld().displayName(5);
    }
}
