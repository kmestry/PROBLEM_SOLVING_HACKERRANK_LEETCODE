package com.leetcode_restart;

public class MoveZerosToEnd {

    public void moveZeroes(int[] nums) {

        int[] result = new int[nums.length];


        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                result[index] = nums[i];
                index++;
            }
        }

        int k = 0;
        for (int i : result) {
            nums[k] = i;
            k++;
        }

    }
}
