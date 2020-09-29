package com.leetcode;

public class SubarrayProductLessThanK {

    public int numSubarrayProductLessThanK(int[] nums, int k) {

        int count = 0;
        //[10, 5, 2, 6], k = 100
        for (int i = 0; i < nums.length; i++) {

            if (nums[i] < k) count++;
            int product = nums[i];

            for (int j = i + 1; j < nums.length; j++) {

                product = product * nums[j];

                if (product < k) {
                    count++;
                } else {
                    break;
                }
            }
        }

        return count;
    }
}
