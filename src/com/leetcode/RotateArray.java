package com.leetcode;

public class RotateArray {

    // we do in place rotation.
    public void rotate(int[] nums, int k) {

        if (k > nums.length)
            k = k % nums.length;

        while (k > 0) {
            int last = nums[nums.length - 1];
            int temp = nums[0];
            for (int i = 1; i < nums.length; i++) {

                int val = nums[i];
                nums[i] = temp;
                temp = val;

            }
            nums[0] = last;
            k--;
        }
        //for(int i : nums){
        //    System.out.println(i);
        // }
    }
}
