package com.mypractice.loop;

public class Problem23 {
    public static void main(String[] args) {
      problemFunction(10);
    }

    private static void problemFunction(int n) {
        int i=1, s=1;
        while (s<=n){
            i++;
            s = s+i;
            System.out.println("*");
        }
    }

}
