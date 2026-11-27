package com.mypractice.designpattern.bridgepattern.productimpl;

import com.mypractice.designpattern.bridgepattern.product.Product;

public class GearLocking implements Product {
    private final String productName;

    public GearLocking(String productName) {
        this.productName = productName;
    }

    @Override
    public String productName() {
        return productName;
    }

    @Override
    public void produce() {
        System.out.println("GearLocking System !!!!");
    }
}
