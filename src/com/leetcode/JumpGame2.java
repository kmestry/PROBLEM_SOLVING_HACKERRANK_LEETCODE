package com.leetcode;

public class JumpGame2 {

    //naive approach- incorrect.

    public static void main(String[] args) {
        // new JumpGame2().jump(new int[]{2, 3, 1, 1, 4 });
        // int result = new JumpGame2().jump(new int[]{2, 1});
        int result = new JumpGame2().jump(new int[]{10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 1, 0});
        System.out.println("result = " + result);
    }

    public int jump(int[] nums) {

        int startIndex = 0;
        int count = 0;
        if (nums.length == 1) {
            return 0;
        }
        for (int i = startIndex; i < nums.length; i++) {

            i = startIndex;
            if (i + nums[i] >= nums.length - 1) {
                return count + 1;
            }


            int num = nums[i];

            int max = Integer.MIN_VALUE;
            int maxIndex = -1;
            int end = num + i;
            for (int j = i + 1; j <= end; j++) {
                if (nums[j] >= max) {
                    max = nums[j];
                    maxIndex = j;
                }
            }

            startIndex = maxIndex;
            count++;
        }

        return -1;


    }
}
