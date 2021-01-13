package com.java.concurrent_util_java2blogsite.exchanger;

import java.util.concurrent.Exchanger;

public class Consumer implements Runnable {

    Exchanger exchanger;

    public Consumer(Exchanger exchanger) {
        this.exchanger = exchanger;
    }

    @Override
    public void run() {

        for (int i = 1; i <= 2; i++) {
            try {
                Country country = (Country) exchanger.exchange(new Country("Dummy"));
                System.out.println("In consumer RUN : got " + country.getCountryName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }
}
