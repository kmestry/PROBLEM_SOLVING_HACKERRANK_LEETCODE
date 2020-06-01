package com.hackerrank.day1;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class SockMerchant {

    // Complete the sockMerchant function below.
    //      9 ==  n
    //      10 20 20 10 10 30 50 10 20  == ar
    static int sockMerchant(int n, int[] ar) {
        //map of integer and the times of occurrence of the integer
        Map<Integer, Integer> sockMap = new HashMap();

        for (int i = 0; i < ar.length; i++) {

            if (sockMap.containsKey(ar[i])) {
                Integer sockValue = sockMap.get(ar[i]);
                sockValue += 1;
                sockMap.put(ar[i], sockValue);
            } else {
                sockMap.put(ar[i], 1);
            }


        }

        int numberOfPairs = 0;
        Collection<Integer> valueMap = sockMap.values();

        for (int value : valueMap) {
            if (value > 1)
                numberOfPairs += value / 2;
        }

        return numberOfPairs;

    }

    public static void main(String[] args) {

        int pairs = sockMerchant(9, new int[]{10, 20, 20, 10, 10, 30, 50, 10, 20});
        System.out.println("pairs = " + pairs);


     /*   AtomicInteger numberOfPair = new AtomicInteger();

        sockMap.forEach((key, value) -> {
            if (value > 1) {
                int evenValue = value / 2;
                numberOfPair.addAndGet(evenValue);
            }
        });

        return numberOfPair.get();*/
    }
}
