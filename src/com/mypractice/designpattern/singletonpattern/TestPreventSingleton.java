package com.mypractice.designpattern.singletonpattern;

import com.mypractice.designpattern.singletonpattern.prevent.PreventSingleTon;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class TestPreventSingleton {
    public static void main(String[] args) {
        System.out.println(PreventSingleTon.getInstance().hashCode());
        System.out.println(PreventSingleTon.getInstance().hashCode());
        breakByCloning();
        breakBySerilization();
        breakByReflection();
    }

    private static void breakByReflection() {
        System.out.println("Start TestSingletonPattern.breakByReflection");
        PreventSingleTon instance1 = PreventSingleTon.getInstance();
        PreventSingleTon instance2 = null;
        Constructor[] constructors = PreventSingleTon.class.getDeclaredConstructors();
        for (Constructor constructor : constructors) {
            constructor.setAccessible(true);
            try {
                instance2 = (PreventSingleTon) constructor.newInstance();
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
    private static void breakBySerilization() {
        System.out.println("Start TestSingletonPattern.breakBySerilization");

        try {
            PreventSingleTon instance1 = PreventSingleTon.getInstance();
            ObjectOutput out
                    = new ObjectOutputStream(new FileOutputStream("file.text"));
            out.writeObject(instance1);
            out.close();

            // deserailize from file to object
            ObjectInput in
                    = new ObjectInputStream(new FileInputStream("file.text"));

            PreventSingleTon instance2 = (PreventSingleTon) in.readObject();
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


    private static void breakByCloning() {
        System.out.println("Start TestSingletonPattern.breakByCloning");
        PreventSingleTon instance1 = PreventSingleTon.getInstance();
        PreventSingleTon instance2 = null;
        try {
            instance2 = (PreventSingleTon) instance1.clone();
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
