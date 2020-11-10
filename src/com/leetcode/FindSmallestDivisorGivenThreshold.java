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

    public int smallestDivisorBinarySearch(int[] nums, int threshold) {

        int l = 0;
        int r = 1000000;

        while (l <= r) {

            int divisor = l + (r - l) / 2;
            int sum = 0;
            for (int i = 0; i < nums.length; i++) {
                double divided = (double) nums[i] / (double) divisor;

                sum += Math.ceil(divided);
            }
            //when divisor increases sum will be smaller
            if (sum > threshold) {
                l = divisor + 1;
            } else {
                r = divisor - 1;
            }


        }

        return l;

    }
}