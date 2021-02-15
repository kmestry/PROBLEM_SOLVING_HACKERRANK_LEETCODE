package com.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LongestHarmonicSequence {

    public static void main(String[] args) {
        new LongestHarmonicSequence().findLHS(new int[]{1, 3, 2, 2, 5, 2, 3, 7});
        //new LongestHarmonicSequence().findLHS(new int[]{3,2,1});
        // new LongestHarmonicSequence().findLHS(new int[]{-3,-1,-1,-1,-3,-2});
        // new LongestHarmonicSequence().findLHS(new int[]{1, 1, 1, 1});
    }

    public int findLHS(int[] nums) {


        Map<Integer, Integer> freqMap = new HashMap<>();

        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        int result = 0;
        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            int key = entry.getKey();
            int value = entry.getValue();

            if (freqMap.containsKey(key + 1))
                result = Math.max(result, value + freqMap.get(key + 1));
        }
        return result;
    }
}
