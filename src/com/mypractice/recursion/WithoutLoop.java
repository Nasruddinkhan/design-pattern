package com.mypractice.recursion;

public class WithoutLoop {
    public static void main(String[] args) {
        printValue(5);
    }

    private static void printValue(int no) {
        if(no > 0){
            System.out.println("printValue  = "+ no);
            printValue(no -1);
        }
    }
}
