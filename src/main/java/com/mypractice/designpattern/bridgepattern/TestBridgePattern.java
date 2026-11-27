package com.mypractice.designpattern.bridgepattern;

import com.mypractice.designpattern.bridgepattern.car.Car;
import com.mypractice.designpattern.bridgepattern.product.Product;
import com.mypractice.designpattern.bridgepattern.productimpl.CentralLocking;
import com.mypractice.designpattern.bridgepattern.productimpl.GearLocking;
import com.mypractice.designpattern.bridgepattern.wheel.BigWheel;
import com.mypractice.designpattern.bridgepattern.wheel.Motoren;

/**
 * When we avoid permanent binding between an abstraction and its implementations. This might be case,
 * for example when the implement must be selected or switched at run time.
 *
 * Both the abstractions and their implementations should be extensible by sub-classing. In this case,
 * the bridge pattern lets you combine the different abstraction and implementations and extend them independently.
 *
 * Changes in the implementation of an abstraction should have no impact on clients, that is,
 * their code should not have to be recompiled.
 *
 * You want to share an implementations among multiple objects (perhaps using the reference counting), & this fact
 * should be hidden from the client.
 */
public class TestBridgePattern {
    public static void main(String[] args) {

        Product product = new CentralLocking("Central Locking System");
        Product product2 = new GearLocking("Gear Locking System");

        Car car = new BigWheel(product, "Bigheel xz Model");
        car.produceProduct();
        car.assemble();
        car.printDetails();
        System.out.println();

        car = new BigWheel(product2, "Bigheel xz Model");
        car.produceProduct();
        car.assemble();
        car.printDetails();
        System.out.println();

        car = new Motoren(product, "Motoren xz Model");
        car.produceProduct();
        car.assemble();
        car.printDetails();

        car = new Motoren(product2, "Motoren xz Model");
        car.produceProduct();
        car.assemble();
        car.printDetails();


    }
}
