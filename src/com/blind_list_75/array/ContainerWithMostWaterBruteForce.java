package com.blind_list_75.array;

public class ContainerWithMostWaterBruteForce {

    public int maxArea(int[] height) {

        int maxArea = Integer.MIN_VALUE;

        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++) {
                int dist = j - i;
                maxArea = Math.max(maxArea, dist * Math.min(height[i], height[j]));
            }
        }

        return maxArea;

    }
}
