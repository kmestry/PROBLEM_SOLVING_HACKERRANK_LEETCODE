package com.java.concurrent_util_java2blogsite.exchanger;

import java.util.concurrent.Exchanger;

public class ExchangerMain {

    public static void main(String[] args) {
        Exchanger exchanger = new Exchanger();
        Thread t1 = new Thread(new Producer(exchanger));
        Thread t2 = new Thread(new Consumer(exchanger));

        t1.start();
        t2.start();
    }
}
