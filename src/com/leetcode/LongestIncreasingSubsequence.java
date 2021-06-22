package com.leetcode;

import java.util.Arrays;

public class LongestIncreasingSubsequence {

    public static void main(String[] args) {
        new LongestIncreasingSubsequence().lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18});
    }

    public int lengthOfLIS(int[] nums) {

        if (nums.length == 0) return 0;
        int[] lis = new int[nums.length];
        Arrays.fill(lis, 1);

        int i = 1;
        int j = 0;

        while (i < nums.length) {
            while (j < i) {

                if (nums[i] > nums[j] && lis[i] <= lis[j]) {
                    lis[i] = 1 + lis[j];
                }
                j++;
            }
            i++;
            j = 0;
        }

        int maxLis = Integer.MIN_VALUE;

        for (int k = 0; k < lis.length; k++) {
            maxLis = Math.max(maxLis, lis[k]);
        }


        return maxLis;
    }

    public int lengthOfLISPractise(int[] nums) {

        int j = 0;
        int i = 1;
        int[] lis = new int[nums.length];
        Arrays.fill(lis, 1);
        while (i < nums.length) {
            while (j < i) {

                if (nums[i] > nums[j] && lis[i] <= lis[j]) {
                    lis[i] = 1 + lis[j];
                }
                j++;
            }
            i++;
            j = 0;
        }
        int maxLis = Integer.MIN_VALUE;

        for (int k = 0; k < lis.length; k++) {
            maxLis = Math.max(maxLis, lis[k]);
        }


        return maxLis;


    }
}
