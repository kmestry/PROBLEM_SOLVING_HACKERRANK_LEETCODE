package com.leetcode;

public class SubArraySumEqualsK {

    public static void main(String[] args) {
        new SubArraySumEqualsK().subarraySum(new int[]{10, 5, 7, 1, 2, 5, 3}, 15);
    }

    //10 5 7 1 2 5 3 k=15
    public int subarraySum(int[] nums, int k) {

        int resultCounter = 0;
        //subarray with one element
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == k) {
                resultCounter++;
            }
        }

        //sliding window ..first 2 elements.i.e. 0th index and 1st index then 1st index and 2nd index and so on.


        int leftPointer = 0;
        int rightPointer = 1;

        while (leftPointer < nums.length - 1) {

            int initialSum = nums[leftPointer] + nums[rightPointer];

            if (initialSum == k) {
                resultCounter++;
            }


            int runningSum = initialSum;
            int traversalPointer = rightPointer + 1;
            while (traversalPointer < nums.length) {
                runningSum += nums[traversalPointer];
                if (runningSum == k) {
                    resultCounter++;
                }
                traversalPointer++;
            }
            leftPointer++;
            rightPointer++;
        }

        return resultCounter;
    }
}
