package com.leetcode;

import java.util.Arrays;


public class ShortestUnsortedContinuousSubArray {

    public static void main(String[] args) {
        new ShortestUnsortedContinuousSubArray().findUnsortedSubarray(new int[]{1, 2, 3, 4});
    }

    // 2 6 4 8 10 9 15
    // 2 4 6 8 9 10 15
    public int findUnsortedSubarray(int[] nums) {

        int[] cloneArray = nums.clone();

        Arrays.sort(nums);

        if (Arrays.equals(cloneArray, nums)) return 0;

        //find start of unsorted subarray
        int start = -1;
        for (int i = 0; i < cloneArray.length; i++) {
            if (nums[i] != cloneArray[i]) {
                start = i;
                break;
            }
        }

        //find end of unsorted subarray
        int end = -1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] != cloneArray[i]) {
                end = i;
                break;
            }
        }

        return end - start + 1;

    }

}
