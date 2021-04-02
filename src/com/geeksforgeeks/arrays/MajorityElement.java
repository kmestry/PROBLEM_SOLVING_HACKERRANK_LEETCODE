package com.geeksforgeeks.arrays;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement {
    public static void main(String[] args) {
        MajorityElement majorityElement = new MajorityElement();

        int index = majorityElement.majorityElement(new int[]{20, 30, 40, 50, 50, 50, 50});
        System.out.println("index = " + index);
    }

    // Returns majority element first index in the array
    private int majorityElement(int[] array) {

        int countRequired = array.length / 2;
        Map<Integer, Integer> map = new HashMap<>();
        Map<Integer, Integer> uniqueElementFirstIndexMap = new HashMap<>();
        for (int i = 0; i < array.length; i++) {

            if (map.containsKey(array[i])) {
                map.put(array[i], map.get(array[i]) + 1);
            } else {
                map.put(array[i], 1);
                uniqueElementFirstIndexMap.put(array[i], i);
            }
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > countRequired) {
                return uniqueElementFirstIndexMap.get(entry.getKey());
            }
        }

        return -1;

    }
}


