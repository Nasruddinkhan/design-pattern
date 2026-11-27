package com.mypractice.java8.lamda;

import com.mypractice.java8.lamda.AdditionLambda;
import com.mypractice.java8.lamda.HelloLambda;

public class ClientApp {
    public static void main(String[] args) {
       //Anonymous example
/*

        HelloLambda helloLambda = new HelloLambda() {
            @Override
            public void sayHello() {
                System.out.println("Hello Anonymous example");
            }
        };
        helloLambda.sayHello();
        HelloLambda h = ()-> System.out.println("Hello first lambda  example");
        h.sayHello();
        //Anonymous example
        AdditionLambda additionAnonymus = new AdditionLambda() {
            @Override
            public int addition(int no1, int no2) {
                return no1 +  no2;
            }
        };
       int result =  additionAnonymus.addition(10, 20);
       System.out.println("addition anonymos [ "+result+" ]");

       AdditionLambda additionLambda =  (no1, no2) -> no1+no2;
       result = additionLambda.addition(100, 200);
        System.out.println("addition lambda [ "+result+" ]");
*/
        Square square =  (a, b)-> a * b;
        System.out.println(square.squareIt(10,20));
        System.out.println(square.squareIt(5,5));

    }

}
