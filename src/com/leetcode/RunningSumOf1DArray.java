package com.leetcode;

public class RunningSumOf1DArray {

    public static void main(String[] args) {
        int[] result = new RunningSumOf1DArray().runningSum(new int[]{1, 2, 3, 4});
        for (int i : result) {
            System.out.print(i + " ");
        }
    }


    // [1,2,3,4]
    public int[] runningSum(int[] nums) {
        int[] result = new int[nums.length];

        int rightPointer = 0;
        int firstElement = nums[0];
        result[0] = firstElement;

        int resultIndexCounter = 1;
        while (rightPointer < nums.length - 1) {
            result[resultIndexCounter] = result[resultIndexCounter - 1] + nums[resultIndexCounter];
            resultIndexCounter++;
            rightPointer++;
        }

        return result;
    }
}
