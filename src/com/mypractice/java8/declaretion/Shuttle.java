package com.mypractice.java8.declaretion;
class Rocket{
    private void blastOff(){
        System.out.println("Rocket.blastOff");
    }
}

public class Shuttle extends  Rocket{
    public static void main(String[] args) {
        new Shuttle().go();
    }

    private void go() {
        blastOff();
    }
    private void blastOff(){
        System.out.println("Shuttle.blastOff");
    }
}
