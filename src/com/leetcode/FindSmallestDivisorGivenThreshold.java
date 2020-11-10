package com.leetcode;

public class FindSmallestDivisorGivenThreshold {

    public static void main(String[] args) {
        new FindSmallestDivisorGivenThreshold().smallestDivisor(new int[]{1, 2, 5, 9}, 6);
    }

    public int smallestDivisor(int[] nums, int threshold) {

        int divisor = 1;

        int sum = Integer.MAX_VALUE;

        while (sum > threshold) {
            sum = 0;
            for (int i = 0; i < nums.length; i++) {
                double divided = (double) nums[i] / (double) divisor;

                sum += Math.ceil(divided);
            }
            System.out.println("s" + sum);
            System.out.println("d" + divisor);
            divisor++;

        }

        return divisor - 1;

    }
}