package com.java.concurrent_util_java2blogsite.exchanger;

import java.util.concurrent.Exchanger;

public class Producer implements Runnable {

    Exchanger exchanger;

    public Producer(Exchanger exchanger) {
        this.exchanger = exchanger;
    }


    @Override
    public void run() {

        for (int i = 1; i <= 2; i++) {
            Country country = new Country("Country : " + i);
            try {
                Country countryDummy = (Country) exchanger.exchange(country);
                System.out.println("In Producer run, got :" + countryDummy.getCountryName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
