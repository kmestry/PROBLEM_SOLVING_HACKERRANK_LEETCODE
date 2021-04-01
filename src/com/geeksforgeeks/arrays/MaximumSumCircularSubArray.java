package com.geeksforgeeks.arrays;

public class MaximumSumCircularSubArray {

    // 5 -2 3 4
    public static void main(String[] args) {

        MaximumSumCircularSubArray maximumSumCircularSubArray = new MaximumSumCircularSubArray();
        int result = maximumSumCircularSubArray.maximumSum(new int[]{2, 3, -4});
        System.out.println("result = " + result);
    }

    private int maximumSum(int[] array) {

        //TLE solution.
        // correct solution.
        int maxSum = Integer.MIN_VALUE;

        for (int i = 0; i < array.length; i++) {
            int currSum = array[i];
            maxSum = Math.max(maxSum, currSum);
            for (int j = 1; j < array.length; j++) { // j always starts from 1.
                int index = (i + j) % array.length; // imp step to move in array in circular manner

                currSum += array[index];
                maxSum = Math.max(maxSum, currSum);
            }
        }

        return maxSum;
    }
}
