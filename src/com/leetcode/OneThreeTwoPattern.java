package com.leetcode;

import java.util.Stack;

public class OneThreeTwoPattern {

    public static void main(String[] args) {
        boolean result = new OneThreeTwoPattern().find132patternStack(new int[]{3, 1, 4, 2});
        System.out.println("result = " + result);
    }


    public boolean find132pattern(int[] nums) {

        for (int i = 0; i < nums.length; i++) {

            if (i + 1 < nums.length && nums[i] == nums[i + 1]) {
                continue;
            }
            for (int j = i + 1; j < nums.length; j++) {

                if (j + 1 < nums.length && nums[j] == nums[j + 1]) {
                    continue;
                }
                for (int k = j + 1; k < nums.length; k++) {


                    if (k + 1 < nums.length && nums[k] == nums[k + 1]) {
                        continue;
                    }

                    //  System.out.println("i" + nums[i]);
                    //   System.out.println("j" + nums[j]);
                    //  System.out.println("k" + nums[k]);

                    if (nums[i] < nums[k] && nums[k] < nums[j]) {
                        return true;
                    }

                }
            }
        }

        return false;

    }

    public boolean find132patternOptimalBruteForce(int[] nums) {


        int minI = Integer.MAX_VALUE;

        for (int j = 0; j < nums.length; j++) {
            minI = Math.min(nums[j], minI);

            for (int k = j + 1; k < nums.length; k++) {

                if (minI < nums[k] && nums[k] < nums[j]) {
                    return true;
                }
            }
        }

        return false;
    }

    public boolean find132patternStack(int[] nums) {
        Stack<Integer> stack = new Stack();
        int second = Integer.MIN_VALUE;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] < second)
                return true;
            while (!stack.isEmpty() && nums[i] > stack.peek())
                second = stack.pop();
            stack.push(nums[i]);
        }
        return false;
    }


    public boolean find132patternBruteForceCustom(int[] nums) {

        if (nums == null || nums.length < 3) return false;

        for (int j = 1; j < nums.length; j++) {
            int numJ = nums[j];

            int lowestInLeft = Integer.MAX_VALUE;
            for (int i = 0; i < j; i++) {
                lowestInLeft = Math.min(lowestInLeft, nums[i]);
            }

            if (lowestInLeft < numJ) {

                for (int k = j + 1; k < nums.length; k++) {

                    if (nums[k] < numJ && lowestInLeft < nums[k]) {
                        return true;
                    }

                }

            }

        }
        return false;

    }
}
