package com.leetcode;

public class HouseRobberSeptChallenge {

    public static void main(String[] args) {

        new HouseRobberSeptChallenge().rob(new int[]{1, 2, 1, 1});
    }

    public int rob(int[] nums) {

        Integer[] dp = new Integer[nums.length + 1];
        return helper(nums, 0, 0, dp);
        // return maxRobbery;
    }

    private int helper(int[] nums, int index, int currRobbery, Integer[] dp) {

        if (index > nums.length - 1) {

            return currRobbery;
        }

        if (dp[index] != null)
            return dp[index];


        int robberyDone = helper(nums, index + 2, currRobbery + nums[index], dp); // if robbery done. skip next house.
        int robberyNotDone = helper(nums, index + 1, currRobbery, dp);//robbery not done.

        int maxRobbery = Math.max(robberyDone, robberyNotDone);

        dp[index] = maxRobbery;

        return maxRobbery;

    }
}
