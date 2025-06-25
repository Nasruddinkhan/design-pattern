package com.mypractice.oops;

import java.util.ArrayList;
import java.util.List;

//abstraction
interface IWorkable{
    void doWork();
}

// encapsulation
class Person{
    private String name;
    private int age;
    private String role;

    public Person(String name, int age, String role) {
        this.name = name;
        this.age = age;
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getRole() {
        return role;
    }
    public void introduce(){
        System.out.printf("My name is %s. I am %s year old and the %s of this land %n", name, age, role);
    }

}
class King extends Person implements IWorkable {
    public King(String name, int age) {
        super(name, age, "King");
    }

    public void command(){
        System.out.println("All citizens do your duty");
    }

    @Override
    public void doWork() {
        System.out.println("keep on eye in our king dom");
    }
}

class Soldier extends Person implements IWorkable{

    public Soldier(String name, int age) {
        super(name, age, "Soldier");
    }

    public void onDuty(){
        System.out.println(String.format("%s is  protect our land from other enemy", getName()));
    }
    @Override
    public void doWork() {
        this.onDuty();
    }
}

class Farmer extends Person implements IWorkable{

    public Farmer(String name, int age) {
        super(name, age, "Farmer");
    }

    public void farming(){
        System.out.println(String.format("The harvest supports %s livelihood and future planning", getName()));
    }
    @Override
    public void doWork() {
        this.farming();
    }
}
public class KingLand {
    public static void main(String[] args) {
        System.out.println("king land is working fine");
        List<IWorkable>  citizens = new ArrayList<>();
        King kg = new King("Gayasuddin Khan", 45);
        citizens.add(kg);
        citizens.add(new Soldier("Nasruddin Khan", 30));
        citizens.add(new Farmer("Ayan Khan", 20));
        citizens.stream().filter(s -> s instanceof  Person).map(s-> (Person) s).forEach(Person::introduce);
        kg.command();
        citizens.forEach(IWorkable::doWork);

    }
}
