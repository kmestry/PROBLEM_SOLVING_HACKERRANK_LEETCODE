package com.leetcode_restart;


public class TwoSumSortedInputArray {

    public int[] twoSum(int[] nums, int target) {

        int l = 0;
        int r = nums.length - 1;
        int[] result = new int[2];

        while (l <= r) {
            int sum = nums[l] + nums[r];

            if (sum == target) {
                result[0] = l + 1;
                result[1] = r + 1;
                return result;
            }

            if (sum > target) {
                r--;
            } else {
                l++;
            }
        }

        return result;
    }
}
