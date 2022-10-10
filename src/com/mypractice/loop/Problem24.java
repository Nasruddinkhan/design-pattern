package com.mypractice.loop;

public class Problem24 {
    public static void main(String[] args) {
        problem(5);
    }

    private static void problem(int no) {
        int i, count =0;
        for ( i = 1; i*i <=no ; i++)
            count++;
        System.out.println("count = " + count);

    }
}
