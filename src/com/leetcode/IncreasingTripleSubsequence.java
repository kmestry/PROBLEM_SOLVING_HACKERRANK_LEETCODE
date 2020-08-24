package com.leetcode;

public class IncreasingTripleSubsequence {

    public static void main(String[] args) {

        new IncreasingTripleSubsequence().increasingTriplet(new int[]{1, 2, 0, 3});
    }

    //as it appears to be very naïve and greedy: find first smallest, then find second smallest, then find the third and bingo.
    public boolean increasingTriplet(int[] nums) {

        if (nums.length < 3) return false;

        int smallest = Integer.MAX_VALUE;
        int secondSmallest = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];

            if (num < smallest) smallest = num;
            else if (num > smallest && num < secondSmallest) secondSmallest = num;
            else if (num > smallest && num > secondSmallest) return true;
        }

        return false;


    }
}
