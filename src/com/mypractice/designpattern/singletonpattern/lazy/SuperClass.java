package com.mypractice.designpattern.singletonpattern.lazy;

public class SuperClass implements Cloneable {
    int i = 10;

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}