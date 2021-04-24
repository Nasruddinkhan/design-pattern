package com.mypractice.designpattern.adapterpattern;

import com.mypractice.designpattern.adapterpattern.adapter.XpayToPayDAdapter;
import com.mypractice.designpattern.adapterpattern.payd.PayD;
import com.mypractice.designpattern.adapterpattern.xpay.Xpay;
import com.mypractice.designpattern.adapterpattern.xpayimpl.XpayImpl;

public class AdapterPatternTest {
    public static void main(String[] args) {
        Xpay xpay = new XpayImpl();
        xpay.setCreditCardNo("1234567891114534");
        xpay.setCustomerName("Nasruddin khan");
        xpay.setCardExpMonth("05");
        xpay.setCardExpYear("2024");
        xpay.setCardCVVNo((short)199);
        xpay.setAmmount(2555.50);
        PayD payD = new XpayToPayDAdapter(xpay);
        testPayment(payD);
    }

    private static void testPayment(PayD payD) {
        System.out.println("payD.getCustCardNo() = " + payD.getCustCardNo());
        System.out.println("payD.getCardOwnerName() = " + payD.getCardOwnerName());
        System.out.println("payD.getCardExpMonthDate() = " + payD.getCardExpMonthDate());
        System.out.println("payD.getCVVNo() = " + payD.getCVVNo());
        System.out.println("payD.getTotalAmmount() = " + payD.getTotalAmmount());
    }
}
