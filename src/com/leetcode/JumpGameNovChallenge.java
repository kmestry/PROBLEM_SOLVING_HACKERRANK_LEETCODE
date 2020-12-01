package com.leetcode;

public class JumpGameNovChallenge {

    //fail last test case [4,2,0,0,1,1,4,4,4,0,4,0]
    public boolean canJump(int[] nums) {
        //[5,9,3,2,1,0,2,3,3,1,0,0]
        //[2,3,1,1,4]
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (num == 0 && i != nums.length - 1) {
                return false;
            }
            if (i + num >= nums.length - 1) {
                return true;
            } else {
                int max = Integer.MIN_VALUE;
                int maxIndex = -1;
                int bound = i + num;

                for (int j = i + 1; j <= bound; j++) {
                    if (nums[j] >= max) {
                        max = nums[j];
                        maxIndex = j;
                    }
                }
                System.out.println(maxIndex);
                //System.out.println(i);
                i = maxIndex - 1;
            }
        }

        return false;

    }
}
