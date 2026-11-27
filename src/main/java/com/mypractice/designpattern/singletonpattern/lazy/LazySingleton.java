package com.mypractice.designpattern.singletonpattern.lazy;

import java.io.Serializable;

public class LazySingleton extends SuperClass implements Serializable {
    public static LazySingleton lazySingleton = null;

    private LazySingleton() {
    }

    public static LazySingleton getInstance() {
        if (lazySingleton == null)
            lazySingleton = new LazySingleton();
        return lazySingleton;
    }

}
