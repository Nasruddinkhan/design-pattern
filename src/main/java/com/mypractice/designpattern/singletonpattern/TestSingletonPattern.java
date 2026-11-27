package com.mypractice.designpattern.singletonpattern;

import com.mypractice.designpattern.singletonpattern.eager.EagerSingleton;
import com.mypractice.designpattern.singletonpattern.eager.SingletonEager;
import com.mypractice.designpattern.singletonpattern.lazy.LazySingleton;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestSingletonPattern {
    public static void main(String[] args) {
        System.out.println("Eager Singleton Start @@@@@@@");
        System.out.println(EagerSingleton.eagerSingleton.hashCode());
        System.out.println(EagerSingleton.eagerSingleton.hashCode());
        System.out.println(SingletonEager.getInstance().hashCode());
        System.out.println(SingletonEager.getInstance().hashCode());
        System.out.println("Eager Singleton End @@@@@@@");
        System.out.println("Lazy Singleton Start @@@@@@@");
        System.out.println(LazySingleton.getInstance().hashCode());
        System.out.println(LazySingleton.getInstance().hashCode());
        System.out.println("Lazy Singleton End @@@@@@@");

        breakByCloning();
        breakByReflection();
        breakBySerilization();
        breakByThread();
    }

    private static void breakByThread() {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        /**
         * Run this code snippet after commenting the other code for better understanding
         * Run it repeatly to create a condition when 2 threads enter the method getInstance() of Singleton class at a same time
         * When 2 threads enter the getInstance method at same time they will get the singleton object as null (private static Singleton singleton in Singleton.java)
         * Then they will create two different objects ( have different hashcode) in this case singleton pattern will break.
         */
        executorService.submit(TestSingletonPattern::useSingleton); // JAVA 8 syntax it will get the singleton instance
        executorService.submit(TestSingletonPattern::useSingleton);
        executorService.shutdown();
    }

    public static void useSingleton() {
        LazySingleton singleton = LazySingleton.getInstance();
        System.out.println(Thread.currentThread().getName()+" "+ singleton.hashCode());
    }



    private static void breakBySerilization() {
        System.out.println("Start TestSingletonPattern.breakBySerilization");

        try {
            LazySingleton instance1 = LazySingleton.getInstance();
            ObjectOutput out
                    = new ObjectOutputStream(new FileOutputStream("file.text"));
            out.writeObject(instance1);
            out.close();

            // deserailize from file to object
            ObjectInput in
                    = new ObjectInputStream(new FileInputStream("file.text"));

            LazySingleton instance2 = (LazySingleton) in.readObject();
            in.close();

            System.out.println("instance1 hashCode:- "
                    + instance1.hashCode());
            System.out.println("instance2 hashCode:- "
                    + instance2.hashCode());
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("End TestSingletonPattern.breakBySerilization");
    }

    private static void breakByReflection() {
        System.out.println("Start TestSingletonPattern.breakByReflection");
        LazySingleton instance1 = LazySingleton.getInstance();
        LazySingleton instance2 = null;
        Constructor[] constructors = LazySingleton.class.getDeclaredConstructors();
        for (Constructor constructor : constructors) {
            constructor.setAccessible(true);
            try {
                instance2 = (LazySingleton) constructor.newInstance();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
            break;
        }
        System.out.println("instance1.hashCode():- "
                + instance1.hashCode());
        System.out.println("instance2.hashCode():- "
                + instance2.hashCode());
        System.out.println("End TestSingletonPattern.breakByReflection");

    }

    private static void breakByCloning() {
        System.out.println("Start TestSingletonPattern.breakByCloning");
        LazySingleton instance1 = LazySingleton.getInstance();
        LazySingleton instance2 = null;
        try {
            instance2 = (LazySingleton) instance1.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        System.out.println("instance1 hashCode:- "
                + instance1.hashCode());
        System.out.println("instance2 hashCode:- "
                + instance2.hashCode());
        System.out.println("End TestSingletonPattern.breakByCloning @@@@@");

    }


}
