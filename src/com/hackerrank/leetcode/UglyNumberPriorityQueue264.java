package com.hackerrank.leetcode;

import java.util.TreeSet;

public class UglyNumberPriorityQueue264 {

    public static void main(String[] args) {
        int result = nthUglyNumber(10);
        System.out.println(result);
    }

    public static int nthUglyNumber(int n) {
        if (n == 1) return n;
        TreeSet<Long> set = new TreeSet<>();
        int[] nums = {2, 3, 5};
        Long result = Long.valueOf(1);
        set.add(result);
        for (int i = 0; i < n; i++) {
            // Each time we poll the peak value of q, is the ith number
            result = set.pollFirst();
            for (int num : nums) {
                Long uglyNum = result * num;
                set.add(uglyNum);
            }
        }
        return result.intValue();
    }
}
