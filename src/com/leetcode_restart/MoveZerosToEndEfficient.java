package com.leetcode_restart;

public class MoveZerosToEndEfficient {
    public void moveZeroes(int[] nums) {

        int index = 0;
        for (int i : nums) {
            if (i != 0) {
                nums[index] = i;
                index++;
            }
        }

        for (int i = index; i < nums.length; i++) {
            nums[i] = 0;
        }

    }
}
