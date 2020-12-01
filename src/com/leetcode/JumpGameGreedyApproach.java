package com.leetcode;

public class JumpGameGreedyApproach {

    public static void main(String[] args) {

        new JumpGameGreedyApproach().canJump(new int[]{4, 2, 0, 0, 1, 1, 4, 4, 4, 0, 4, 0});
    }

    //[2,3,1,1,4]
    public boolean canJump(int[] nums) {

        int targetIndex = nums.length - 1;


        for (int i = nums.length - 2; i >= 0; i--) {

            int element = nums[i];
            if (element + i >= targetIndex) {
                targetIndex = i;
            }


        }

        return targetIndex == 0;

    }
}
