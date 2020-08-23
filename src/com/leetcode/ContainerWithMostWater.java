package com.leetcode;

public class ContainerWithMostWater {

    public static void main(String[] args) {
        new ContainerWithMostWater().maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7});
    }

    // [1,8,6,2,5,4,8,3,7]
    public int maxArea(int[] height) {

        int maxArea = Integer.MIN_VALUE;

        int distance;
        for (int i = 0; i < height.length; i++) {
            distance = 1;
            for (int j = i + 1; j < height.length; j++) {
                int min = Math.min(height[i], height[j]);
                int areaWithMostWater = min * distance;
                if (areaWithMostWater > maxArea) maxArea = areaWithMostWater;
                distance++;
            }
        }

        return maxArea;
    }
}
