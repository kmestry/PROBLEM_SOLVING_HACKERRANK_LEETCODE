package com.leetcode;

import java.util.TreeSet;

public class MinimumDeviationInArray {

    public int minimumDeviation(int[] nums) {
        TreeSet<Integer> set = new TreeSet<>();

        for (int n : nums) {
            if (n % 2 == 1) {
                set.add(n * 2); // multiple odd num by 2 and add
            } else {
                set.add(n);
            }
        }
        //System.out.println("==" + set);
        int minDiff = Integer.MAX_VALUE;
        while (set.last() % 2 == 0) {
            int max = set.last();
            int min = set.first();

            minDiff = Math.min(max - min, minDiff);


            set.remove(max);
            set.add(max / 2);
        }

        if (set.last() % 2 == 1) {
            minDiff = Math.min(set.last() - set.first(), minDiff);
        }

        return minDiff;
    }
}
