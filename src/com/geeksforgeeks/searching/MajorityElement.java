package com.geeksforgeeks.searching;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement {

    static int majorityElement(int[] a, int size) {
        // your code here
        Map<Integer, Integer> freqMap = new HashMap<>();

        for (int num : a) {

            if (freqMap.containsKey(num)) {
                freqMap.put(num, freqMap.get(num) + 1);
            } else {
                freqMap.put(num, 1);
            }


            if (freqMap.get(num) > a.length / 2) {
                return num;
            }
        }

        return -1;


    }
}
