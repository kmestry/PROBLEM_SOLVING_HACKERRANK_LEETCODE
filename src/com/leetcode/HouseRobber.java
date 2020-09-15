package com.leetcode;

import java.util.HashMap;
import java.util.Map;

public class HouseRobber {

    Map<Integer, Integer> map = new HashMap<>();

    public static void main(String[] args) {
        new HouseRobber().rob(new int[]{2, 1, 1, 2});
    }

    public int rob(int[] nums) {

        Integer[] dp = new Integer[nums.length + 1];
        return helper(nums, 0, dp);
        // return maxRobbery;
    }

    private int helper(int[] nums, int index, Integer[] dp) {


        if (index >= nums.length) {

            return 0;
        }

        if (dp[index] != null)
            return dp[index];


        int robberyDone = helper(nums, index + 2, dp) + nums[index]; //robbery done. skip next house.
        int robberyNotDone = helper(nums, index + 1, dp);//robbery not done.

        int maxRobbery = Math.max(robberyDone, robberyNotDone);

        dp[index] = maxRobbery;

        return maxRobbery;

    }
}
