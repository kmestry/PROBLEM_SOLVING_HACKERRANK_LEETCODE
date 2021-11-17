package com.leetcode;

import java.util.Stack;

public class FIndTheMostCompetitiveSubsequenceOptimized {

    public static void main(String[] args) {
        int[] nums = new FIndTheMostCompetitiveSubsequenceOptimized().mostCompetitive(new int[]{71, 18, 52, 29, 55, 73, 24, 42, 66, 8, 80, 2}, 3);
        System.out.println("nums = " + nums);
    }

    public int[] mostCompetitive(int[] nums, int k) {
        Stack<Integer> stack = new Stack<>();

        int attempts = nums.length - k;

        for (int num : nums) {
            while (!stack.isEmpty() && stack.peek() > num && attempts > 0) {
                stack.pop();
                attempts--;
            }
            stack.push(num);
        }
        while (stack.size() > k) {
            stack.pop();
        }
        System.out.println("stack = " + stack);
        return stack.stream().mapToInt(i -> i).toArray();
    }
}
