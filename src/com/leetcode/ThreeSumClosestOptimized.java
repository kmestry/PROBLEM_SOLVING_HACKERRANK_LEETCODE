package com.leetcode;

import java.util.Arrays;

public class ThreeSumClosestOptimized {

    public static void main(String[] args) {
        new ThreeSumClosestOptimized().threeSumClosest(new int[]{-1, 2, 1, -4}, 1);
    }

    public int threeSumClosest(int[] nums, int target) {


        int closestSum = 0;
        int closest = Integer.MAX_VALUE;
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {

            int left = i + 1;

            int right = nums.length - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum == target) {
                    return sum;
                }

                if (sum > target) {
                    right--;
                }

                if (sum < target) {
                    left++;
                }

                int diff = Math.abs(target - sum);

                if (diff < closest) {
                    closest = diff;
                    closestSum = sum;
                }


            }

        }

        return closestSum;
    }
}
