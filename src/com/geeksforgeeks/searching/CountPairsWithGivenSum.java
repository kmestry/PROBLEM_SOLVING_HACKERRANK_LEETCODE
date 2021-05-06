package com.geeksforgeeks.searching;

import java.util.HashMap;
import java.util.Map;

public class CountPairsWithGivenSum {
    public static void main(String[] args) {
        CountPairsWithGivenSum countPairsWithGivenSum = new CountPairsWithGivenSum();
        // countPairsWithGivenSum.getPairsCount(new int[]{1, 5, 7, 1}, 4, 6);
        countPairsWithGivenSum.getPairsCount(new int[]{1, 1, 1, 1}, 4, 2);
    }

    int getPairsCount(int[] arr, int n, int k) {
        // code here

        Map<Integer, Integer> freqMap = new HashMap<>();

        for (int i : arr) {
            if (freqMap.containsKey(i)) {
                freqMap.put(i, freqMap.get(i) + 1);
            } else {
                freqMap.put(i, 1);
            }
        }
        int counter = 0;
        for (int i = 0; i < arr.length; i++) {
            if (freqMap.get(k - arr[i]) != null) {
                counter += freqMap.get(k - arr[i]);
            }

            if (k - arr[i] == arr[i]) {
                counter--;
            }
        }
        return counter / 2;
    }
}
