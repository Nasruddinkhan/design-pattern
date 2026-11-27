package com.mypractice.java8.declaretion;

enum Animals {
    DOG("woof"),
    FISH("burble"),
    CAT("meow");
    String sound;
    Animals(String sound) {
        this.sound = sound;
    }
}
class TestEnum{
    static Animals animals;
    public static void main(String[] args) {
        System.out.println(animals.FISH.sound+" "+animals.CAT.sound);
    }
}

