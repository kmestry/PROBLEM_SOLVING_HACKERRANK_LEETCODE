package com.leetcode;

public class SqrtBinarySearch {

    public static void main(String[] args) {

        int result = mySqrt(1);
        System.out.println(result);
    }

    public static int mySqrt(int x) {

        if (x == 1) {
            return 1;
        }

        int left = 1;
        int right = x / 2;


        int maxNumber = 0;
        while (left <= right) {
            long mid = left + (right - left) / 2;
            if (mid * mid <= x) {
                maxNumber = (int) mid;
                left = (int) (mid + 1);
            } else if (mid * mid > x) {
                right = (int) mid - 1;
            }

        }

        return maxNumber;
    }
}
