package com.leetcode;

import java.util.Arrays;

public class NumberOfLongestIncreasingSubsequenceOptimized {

    public static void main(String[] args) {
        new NumberOfLongestIncreasingSubsequenceOptimized().findNumberOfLIS(new int[]{1, 3, 5, 4, 7});
    }

    public int findNumberOfLIS(int[] nums) {


        int[] lengthArray = new int[nums.length];
        int[] countArray = new int[nums.length];

        Arrays.fill(lengthArray, 1);
        Arrays.fill(countArray, 1);

        int leftToRightPointer = 0;
        int rightPointer = 1;

        while (rightPointer < nums.length) {
            while (leftToRightPointer < rightPointer) {

                if (nums[leftToRightPointer] < nums[rightPointer]) {

                    if (lengthArray[leftToRightPointer] + 1 > lengthArray[rightPointer]) {
                        lengthArray[rightPointer] = lengthArray[leftToRightPointer] + 1;
                        countArray[rightPointer] = countArray[leftToRightPointer];
                    } else if (lengthArray[leftToRightPointer] + 1 == lengthArray[rightPointer]) {
                        countArray[rightPointer] += countArray[leftToRightPointer];
                    }

                }
                leftToRightPointer++;

            }
            rightPointer++;
            leftToRightPointer = 0;
        }


        int maxLISLength = Integer.MIN_VALUE;

        for (int i = 0; i < lengthArray.length; i++) {
            maxLISLength = Math.max(maxLISLength, lengthArray[i]);
        }

        int counter = 0;
        for (int i = 0; i < lengthArray.length; i++) {
            if (lengthArray[i] == maxLISLength) {
                counter += countArray[i];
            }
        }

        return counter;
    }
}
