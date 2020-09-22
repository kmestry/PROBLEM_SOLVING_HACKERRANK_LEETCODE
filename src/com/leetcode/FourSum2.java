package com.leetcode;

import java.util.HashMap;
import java.util.Map;

public class FourSum2 {

    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                int sum = A[i] + B[j];
                if (map.containsKey(sum)) {
                    map.put(sum, map.get(sum) + 1);
                } else {
                    map.put(sum, 1);
                }

            }
        }

        int count = 0;
        for (int i = 0; i < C.length; i++) {
            for (int j = 0; j < D.length; j++) {
                int sum = C[i] + D[j];
                if (map.containsKey(-sum)) {
                    count += map.get(-sum);

                }
            }
        }


        return count;
    }
}
