package com.mypractice.java8.oo;

import java.util.ArrayList;

public class TestAnimals {
    public static void main(String[] args) {
    Animal animal = new Hourse();
    animal.eat();
    }
}
class  Animal{
    public void eat(){
        System.out.println("Animal.eat");
    }
}
class Hourse extends  Animal{
    @Override
    public void eat(){
        ArrayList arrayList = new ArrayList();
                arrayList.add("fsdf");
        System.out.println("Hourse.eat");
    }
    public void buck(){
        System.out.println("Hourse.buck");
    }
}
