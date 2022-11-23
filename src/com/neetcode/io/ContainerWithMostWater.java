package com.neetcode.io;

public class ContainerWithMostWater {

    public int maxArea(int[] height) {

        int maxArea = Integer.MIN_VALUE;

        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++) {
                maxArea = Math.max(maxArea, Math.min(height[i], height[j]) * (j - i));
            }
        }
        return maxArea;
    }
}
