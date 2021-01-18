package com.leetcode;

import java.util.Arrays;

public class MaxNumberOfKSumPairsOptimized {

    public int maxOperations(int[] nums, int k) {

        Arrays.sort(nums);
        int start = 0;
        int end = nums.length - 1;
        int count = 0;
        while (start < end) {
            int sum = nums[start] + nums[end];

            if (sum == k) {
                start++;
                end--;
                count++;
            } else if (sum < k) {
                start++;
            } else {
                end--;
            }
        }

        return count;

    }
}
