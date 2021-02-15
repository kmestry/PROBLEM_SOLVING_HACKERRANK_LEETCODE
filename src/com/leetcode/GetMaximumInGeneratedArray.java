package com.leetcode;

public class GetMaximumInGeneratedArray {

    int max = Integer.MIN_VALUE;
    int iVal = 1; // value to simulate the even, odd pair nums value.
    int count = 0;

    public int getMaximumGenerated(int n) {

        if (n == 0 || n == 1)
            return n;
        int[] nums = new int[n + 1]; // array to store earlier values
        nums[0] = 0;
        nums[1] = 1;
        for (int i = 2; i <= n; i++) {

            //every pair of even , odd from 2nd index has same iVal. update after processing every even, odd pair.
            if (count == 2) {
                iVal++;
                count = 0;
            }

            int val;
            if (i % 2 == 0) {
                val = nums[iVal];
            } else {
                val = nums[iVal] + nums[iVal + 1];
            }

            count++;
            nums[i] = val;
            max = Math.max(max, val);
        }
        return max;
    }

}
