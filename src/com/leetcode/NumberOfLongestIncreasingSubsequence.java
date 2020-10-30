package com.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//MEMORY LIMIT EXCEEDED ON LEETCODE.
public class NumberOfLongestIncreasingSubsequence {

    //[1,3,5,4,7]

    List<Integer> resultList = new ArrayList<>();

    public static void main(String[] args) {
        /*int numberOfLongestIncreasingSubsequence  = new NumberOfLongestIncreasingSubsequence().findNumberOfLIS(new int[]{1, 3, 5, 4, 7});
        System.out.println("numberOfLongestIncreasingSubsequence = " + numberOfLongestIncreasingSubsequence);*/

        /*int result = new NumberOfLongestIncreasingSubsequence().findNumberOfLIS(new int[]{2, 2, 2, 2, 2});
        System.out.println("result = " + result);*/

        int result = new NumberOfLongestIncreasingSubsequence().findNumberOfLIS(new int[]{0, 2, 1, 4, 3, 6, 5, 8, 7, 10, 9, 12, 11, 14, 13, 16, 15, 18, 17, 20, 19, 22, 21, 24, 23, 26, 25, 28, 27, 30, 29, 32, 31, 34, 33, 36, 35, 38, 37, 40, 39, 42, 41, 44, 43, 46, 45, 48, 47, 50, 49, 52, 51, 54, 53, 56, 55, 58, 57, 60, 59, 61});
        System.out.println("result = " + result);
    }

    public int findNumberOfLIS(int[] nums) {

        if (nums == null || nums.length == 0) {
            return 0;
        }

        helper(nums, 0, Integer.MIN_VALUE, 0);


        Map<Integer, Integer> countMap = new HashMap<>();

        int longestIncreasingSubsequenceLength = resultList.stream().max(Integer::compareTo).get();

        for (Integer num : resultList) {

            if (num == longestIncreasingSubsequenceLength) {
                if (countMap.containsKey(num)) {
                    countMap.put(num, countMap.get(num) + 1);
                } else {
                    countMap.put(num, 1);
                }
            }
        }

        return countMap.get(longestIncreasingSubsequenceLength);


    }

    private void helper(int[] nums, int index, int prev, int count) {


        if (index >= nums.length) {
            resultList.add(count);
            return;
        }


        if (nums[index] > prev)
            helper(nums, index + 1, nums[index], count + 1);

        helper(nums, index + 1, prev, count);


    }
}
