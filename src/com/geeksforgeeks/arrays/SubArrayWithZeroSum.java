package com.geeksforgeeks.arrays;

import java.util.HashMap;
import java.util.Map;

public class SubArrayWithZeroSum {

    public static void main(String[] args) {

    }

    private static boolean findsum(int[] arr, int n) {
        //calculate prefix SUm

        int prefixSum = arr[0];
        if (prefixSum == 0) return true;
        Map<Integer, Integer> prefixSumMap = new HashMap<>();
        prefixSumMap.put(prefixSum, 1);

        for (int i = 1; i < arr.length; i++) {
            prefixSum += arr[i];
            if (prefixSum == 0 || prefixSumMap.containsKey(prefixSum)) {

                return true;
            } else {
                prefixSumMap.put(prefixSum, 1);
            }
        }

        return false;

    }
}
