package com.geeksforgeeks.arrays;

import java.util.HashSet;
import java.util.Set;

public class SmallestMissingPositiveNumberOptimized {

    static int missingNumber(int[] arr, int size) {

        // Your code here
        // You can add utility functions (if required)
        Set<Integer> set = new HashSet<>();

        for (int num : arr) {
            if (num > 0) {
                set.add(num);
            }
        }

        for (int i = 1; i <= 1000000; i++) {
            if (!set.contains(i))
                return i;
        }

        return -1;
    }
}
