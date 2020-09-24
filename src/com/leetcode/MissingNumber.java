package com.leetcode;

import java.util.Arrays;

public class MissingNumber {

    public static void main(String[] args) {
        new MissingNumber().missingNumberBinarySearch(new int[]{9, 6, 4, 2, 3, 5, 7, 0, 1});
    }

    public int missingNumber(int[] nums) {

        boolean[] numsCopy = new boolean[nums.length + 1];

        for (int i = 0; i < nums.length; i++) {
            numsCopy[nums[i]] = true;
        }

        for (int i = 0; i < numsCopy.length; i++) {
            if (numsCopy[i] == false)
                return i;
        }


        return -1;
    }


    //sum of [1,n] = n(n+1)/2
    //missing num = sum of [1,n] - sum of all nums in array
    public int missingNumberOptimized(int[] nums) {

        int sum = 0;
        for (int i : nums) {
            sum += i;
        }

        int result = (nums.length * (nums.length + 1)) / 2 - sum;


        return result;

    }

    // xor number and index with the nums.length..
    //remaining number is the answer
    public int missingNumberXor(int[] nums) {
        int missingNum = nums.length;

        for (int i = 0; i < nums.length; i++) {
            missingNum ^= i ^ nums[i];
        }

        return missingNum;
    }

    public int missingNumberBinarySearch(int[] nums) {
        Arrays.sort(nums);
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] > mid) right = mid - 1;
            else left = mid + 1;
        }
        return left;

    }
}
