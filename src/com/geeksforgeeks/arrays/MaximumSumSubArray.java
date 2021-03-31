package com.geeksforgeeks.arrays;

public class MaximumSumSubArray {
    public static void main(String[] args) {

        MaximumSumSubArray maximumSumSubArray = new MaximumSumSubArray();
        int sum = maximumSumSubArray.maximumSumSubArray(new int[]{2, 3, -8, 7, -1, 2, 3});
        System.out.println("sum = " + sum);
    }

    //Naive solution
    //TC N^2
    private int maximumSumSubArray(int[] array) {

        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < array.length; i++) {

            int sum = 0;
            for (int j = i; j < array.length; j++) {
                sum += array[j];
                maxSum = Math.max(maxSum, sum);
            }
        }

        return maxSum;
    }
}
