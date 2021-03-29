package com.geeksforgeeks.arrays;

public class MaximumDifferenceProblem {

    public static void main(String[] args) {

        MaximumDifferenceProblem maximumDifferenceProblem = new MaximumDifferenceProblem();
        int result = maximumDifferenceProblem.maxDifference(new int[]{7, 9, 5, 6, 3, 2});
        System.out.println("result = " + result);
    }

    private int maxDifference(int[] arr) {

        int maxDiff = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {

                maxDiff = Math.max(arr[j] - arr[i], maxDiff);

            }
        }

        return maxDiff;
    }


}
