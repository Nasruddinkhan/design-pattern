package com.mypractice.designpattern.bridgepattern.car;

import com.mypractice.designpattern.bridgepattern.product.Product;

abstract public class Car {
    private final Product product;
    private final String carType;

    protected Car(Product product, String carType) {
        this.product = product;
        this.carType = carType;
    }
    public abstract void assemble();
    public abstract void produceProduct();

    public void printDetails(){
        System.out.println("Car : ["+carType+"] Product : [ "+product.productName()+"]\n");
    }
}
