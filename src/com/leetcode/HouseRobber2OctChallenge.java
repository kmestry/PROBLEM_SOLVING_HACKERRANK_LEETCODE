package com.leetcode;

public class HouseRobber2OctChallenge {

    public static void main(String[] args) {
        new HouseRobber2OctChallenge().rob(new int[]{
                2, 3, 2
        });
    }

    public int rob(int[] nums) {

        if (nums.length < 2) {
            return nums[0];
        }


        int[] case1 = new int[nums.length - 1];

        if (nums.length - 1 >= 0) System.arraycopy(nums, 0, case1, 0, nums.length - 1);

        int[] case2 = new int[nums.length - 1];

        int index = 0;
        for (int i = 1; i < nums.length; i++) {
            case2[index] = nums[i];
            index++;
        }

        int maxMoneyRobbed1 = helper(case1, 0, new Integer[case1.length + 1]);
        int maxMoneyRobbed2 = helper(case2, 0, new Integer[case2.length + 1]);
        return Math.max(maxMoneyRobbed1, maxMoneyRobbed2);

    }

    private int helper(int[] nums, int index, Integer[] dpArray) {

        if (index >= nums.length) {
            return 0;
        }

        if (dpArray[index] != null) {
            return dpArray[index];
        }


        //case 1 : rob from house 0 to n-1;
        int robberyDone = 0;
        int robberyNotDone = 0;
        robberyDone += helper(nums, index + 2, dpArray) + nums[index];
        robberyNotDone += helper(nums, index + 1, dpArray);

        int max = Math.max(robberyDone, robberyNotDone);
        dpArray[index] = max;
        return max;
    }
}
