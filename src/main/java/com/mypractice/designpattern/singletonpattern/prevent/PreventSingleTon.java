package com.mypractice.designpattern.singletonpattern.prevent;

import java.io.ObjectStreamException;
import java.io.Serializable;

public class PreventSingleTon implements Serializable {
    private final static long serialVersionUID = 1L;
    private static PreventSingleTon singleTon = new PreventSingleTon();

    private PreventSingleTon() {
        if (singleTon != null) {
            throw new RuntimeException("Already created");
        }
    }

    public static PreventSingleTon getInstance() {
        return singleTon;
    }

    public Object readResolve() throws ObjectStreamException {
        return singleTon;
    }

    public Object writeReolve() throws ObjectStreamException {
        return singleTon;
    }

    public Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException("Singleton Object cannot be clone");
    }

    private static Class<?> getClass(String className) throws ClassNotFoundException {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        if (classLoader == null)
            classLoader = PreventSingleTon.class.getClassLoader();
        return classLoader.loadClass(className);
    }


}
