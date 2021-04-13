package com.geeksforgeeks.arrays;

import java.util.HashMap;
import java.util.Map;

public class LargestSubArraysOfZerosAndOnes {

    public static void main(String[] args) {
        LargestSubArraysOfZerosAndOnes largestSubArraysOfZerosAndOnes = new LargestSubArraysOfZerosAndOnes();
        largestSubArraysOfZerosAndOnes.maxLen(new int[]{0, 0, 1, 0, 0}, 5);
    }

    int maxLen(int[] arr, int N) {
        // Your code here
        // Convert all the 0's to -1, thus the problem reduces to find the
        //length of largest subarray giving sum 0.


        for (int i = 0; i < N; i++) {
            if (arr[i] == 0) {
                arr[i] = -1;
            }
        }
        int sumTillNow = arr[0];
        for (int i = 1; i < N; i++) {
            sumTillNow += arr[i];
            arr[i] = sumTillNow;
        }

        Map<Integer, Integer> map = new HashMap<>();

        int maxLen = 0;
        for (int i = 0; i < N; i++) {
            if (arr[i] == 0) {
                maxLen = Math.max(maxLen, i + 1);
            } else if (map.containsKey(arr[i])) {
                maxLen = Math.max(maxLen, i - map.get(arr[i]));
            } else {
                map.put(arr[i], i);
            }
        }

        return maxLen;
    }
}
