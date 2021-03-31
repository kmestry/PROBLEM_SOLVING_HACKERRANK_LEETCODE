package com.geeksforgeeks.arrays;

public class MaximumConsecutiveOnes {
    public static void main(String[] args) {

        MaximumConsecutiveOnes maximumConsecutiveOnes = new MaximumConsecutiveOnes();
        int result = maximumConsecutiveOnes.maxConsecutiveOnes(new int[]{1});
        System.out.println("result = " + result);
    }

    // [ 1 0 1 1 1 1 0 1 1 ]
    private int maxConsecutiveOnes(int[] array) {

        int maxOnes = Integer.MIN_VALUE;

        int counter = 0;

        for (int j : array) {
            if (j == 1) {
                counter++;
            } else {
                maxOnes = Math.max(maxOnes, counter);
                counter = 0;
            }
        }

        maxOnes = Math.max(maxOnes, counter);  // if array is [1] else block will not be visited. hence this statement.

        return maxOnes;
    }
}
