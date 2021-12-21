package com.mypractice.designpattern.iterator;

import java.util.function.Consumer;

public class EmailUtil {
    public static void main(String[] args) {
        EmailUtil.send(emailObj ->
                emailObj.from("Nasruddinkhan44@gmail.com")
                        .to("Nasruddinkhan@gmail.com")
                        .cc("Nasruddinkhan@gmail.com")
                        .bcc("Nasruddinkhan@gmail.com")
                        .body("<H1>Email Content </H1>"));

    }

    public void printValue(String inputStr) {
        System.out.println(inputStr);
    }

    private static void send(Consumer<EmailUtil> utilConsumer) {
        EmailUtil emailUtil = new EmailUtil();
        utilConsumer.accept(emailUtil);
        System.out.println("Sending");


    }

    private EmailUtil body(String body) {
        printValue(body);
        return this;
    }

    private EmailUtil bcc(String bcc) {
        printValue(bcc);
        return this;
    }

    private EmailUtil cc(String cc) {
        printValue(cc);
        return this;
    }

    private EmailUtil to(String to) {
        printValue(to);
        return this;
    }

    private EmailUtil from(String from) {
        printValue(from);
        return this;
    }
}

