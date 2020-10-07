package com.leetcode;

public class RotateArrayExtraSpace {

    public void rotate(int[] nums, int k) {


        if (k > nums.length) {
            k = k % nums.length;
        }
        int[] auxArray = new int[nums.length];

        int index = 0;

        for (int i = nums.length - k; i < nums.length; i++) {
            auxArray[index] = nums[i];
            index++;
        }

        for (int i = 0; i < nums.length - k; i++) {
            auxArray[index] = nums[i];
            index++;
        }

        for (int i = 0; i < auxArray.length; i++) {
            nums[i] = auxArray[i];
        }

        //for(int i : nums){
        //    System.out.println(i);
        // }
    }
}
