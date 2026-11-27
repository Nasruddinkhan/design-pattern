package com.mypractice.designpattern.bridgepattern.wheel;

import com.mypractice.designpattern.bridgepattern.car.Car;
import com.mypractice.designpattern.bridgepattern.product.Product;

public class Motoren extends Car {
    private final Product product;
    private final String carType;

    public Motoren(Product product, String carType) {
        super(product, carType);
        this.product = product;
        this.carType = carType;
    }

    @Override
    public void assemble() {
        System.out.println("BigWheel.assembling ["+product.productName()+"] for ["+ carType+"]");
    }

    @Override
    public void produceProduct() {
        product.produce();
        System.out.println("Modify the product ["+product.productName()+"] according to carType [ " +carType+" ]");
    }
}
