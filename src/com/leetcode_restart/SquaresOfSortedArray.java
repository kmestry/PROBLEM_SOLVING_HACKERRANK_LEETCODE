package com.leetcode_restart;

public class SquaresOfSortedArray {

    public int[] sortedSquares(int[] nums) {

        int[] result = new int[nums.length];
        int l = 0;
        int r = nums.length - 1;
        int filler = nums.length - 1;

        while (filler >= 0 && l <= r) {
            int absL = Math.abs(nums[l]);
            int absR = Math.abs(nums[r]);

            if (absL > absR) {
                result[filler] = absL * absL;
                l++;
            } else {
                result[filler] = absR * absR;
                r--;
            }
            filler--;

        }

        return result;
    }
}
