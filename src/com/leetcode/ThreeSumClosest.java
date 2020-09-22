package com.leetcode;

public class ThreeSumClosest {

    public static void main(String[] args) {
        int result = new ThreeSumClosest().threeSumClosest(new int[]{-1, 2, 1, -4}, 1);
        System.out.println("result = " + result);
    }

    public int threeSumClosest(int[] nums, int target) {

        int closestSum = Integer.MAX_VALUE;
        int sumResult = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {

                    int sum = nums[i] + nums[j] + nums[k];

                    int diff;
                    if (sum > target)
                        diff = sum - target;
                    else
                        diff = target - sum;


                    if (diff < closestSum) {
                        sumResult = sum;
                        closestSum = diff;
                    }

                }
            }
        }

        return sumResult;
    }
}
