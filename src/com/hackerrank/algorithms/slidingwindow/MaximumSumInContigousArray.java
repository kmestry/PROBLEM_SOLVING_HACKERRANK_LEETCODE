package com.hackerrank.algorithms.slidingwindow;

import java.io.IOException;

//sliding window solution in O(n) time to find max sum in the window size k in the contiguous array of length k in array nums.
public class MaximumSumInContigousArray {

    public static void main(String[] args) throws IOException {

        maximumSumOfSubArrayInSlidingWindow(new int[]{1, 4, 2, 10, 2, 3, 1, 0, 20}, 4);
        //maximumSumOfSubArrayInSlidingWindow(new int[]{1, 9, -1, -2, 7, 3, -1, 2}, 4);

        // maximumSumOfSubArrayInSlidingWindow(new int[]{3,2,6,-1,4,5,-1,2}, 4);

    }

    public static int maximumSumOfSubArrayInSlidingWindow(int[] nums, int k) {

        int originalWindow = k;
        int maximumSumOfSubArray = 0;

        Integer initialSumOfWindow = Integer.valueOf(0);

        for (int i = 0; i < k; i++) {
            initialSumOfWindow += nums[i];

        }

        maximumSumOfSubArray = initialSumOfWindow;
        int nextSum = initialSumOfWindow;
        System.out.println("nextSum = " + nextSum);

        for (int i = 1; i <= nums.length - k; i++) {
            int sumOfSubArray = nextSum - nums[i - 1] + nums[originalWindow + i - 1];
            nextSum = sumOfSubArray;
            System.out.println("nextSum = " + nextSum);
            if (sumOfSubArray > maximumSumOfSubArray) {
                maximumSumOfSubArray = sumOfSubArray;
            }
        }


        System.out.println("maximumSumOfSubArray = " + maximumSumOfSubArray);
        return maximumSumOfSubArray;
    }

}
