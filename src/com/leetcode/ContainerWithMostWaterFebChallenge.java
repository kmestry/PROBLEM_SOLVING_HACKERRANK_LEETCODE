package com.leetcode;

public class ContainerWithMostWaterFebChallenge {
    // System.out.println(newArea);

    public int maxArea(int[] height) {

        int maxArea = Integer.MIN_VALUE;

        int left = 0;
        int right = height.length - 1;


        while (left < right) {

            boolean isLeftMin = height[left] <= height[right];
            int newArea = (right - left) * Math.min(height[left], height[right]);

            maxArea = Math.max(maxArea, newArea);

            if (isLeftMin) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea;


    }
}