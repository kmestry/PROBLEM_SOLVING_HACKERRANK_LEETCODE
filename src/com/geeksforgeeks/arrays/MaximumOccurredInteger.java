package com.geeksforgeeks.arrays;

import java.util.*;

public class MaximumOccurredInteger {

    public static void main(String[] args) {

    }

    //TLE approach
    public static int maxOccurred(int[] L, int[] R, int n, int maxx) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < L.length; i++) {

            for (int j = L[i]; j <= R[i]; j++) {

                if (map.containsKey(j)) {
                    map.put(j, map.get(j) + 1);
                } else {
                    map.put(j, 1);
                }

            }
        }

        List<Integer> maxOccurringList = new ArrayList<>();


        int maxOccurrence = Integer.MIN_VALUE;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            maxOccurrence = Math.max(maxOccurrence, entry.getValue());
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == maxOccurrence) {
                maxOccurringList.add(entry.getKey());
            }
        }

        if (maxOccurringList.size() == 1) {
            return maxOccurringList.get(0);
        } else {
            return maxOccurringList.stream().min(Comparator.comparingInt(value -> value)).get();
        }


    }

}
