package com.mypractice.designpattern.singletonpattern.eager;

public class SingletonEager {
    public static SingletonEager singletonEager = new
            SingletonEager();
    private SingletonEager(){}
    public static SingletonEager getInstance(){
        return singletonEager;
    }
}
