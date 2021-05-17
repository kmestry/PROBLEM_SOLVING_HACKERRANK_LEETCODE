package com.geeksforgeeks.searching;

import java.util.HashMap;
import java.util.Map;

public class CountOccurrences {

    public int countOccurrence(int[] arr, int n, int k) {
        // your code here,return the answer
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            if (map.containsKey(arr[i])) {
                map.put(arr[i], map.get(arr[i]) + 1);
            } else {
                map.put(arr[i], 1);
            }
        }

        int count = n / k;

        int resultCounter = 0;
        return (int) map.entrySet().stream().
                filter(integerIntegerEntry -> integerIntegerEntry.getValue() > count).count();
    }
}
