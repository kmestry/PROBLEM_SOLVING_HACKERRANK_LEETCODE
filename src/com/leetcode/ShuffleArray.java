package com.leetcode;

public class ShuffleArray {

    public int[] shuffle(int[] nums, int n) {

        int[] result = new int[nums.length];

        int leftPointer = 0;
        int rightPointer = n;

        int index = 0;

        while (rightPointer < nums.length) {

            result[index] = nums[leftPointer];
            result[index + 1] = nums[rightPointer];

            leftPointer++;
            rightPointer++;
            index = index + 2;


        }

        return result;
    }
}
