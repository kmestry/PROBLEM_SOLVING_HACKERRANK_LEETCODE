package com.geeksforgeeks.arrays;

public class TrappingRainWaterOptimized {

    public static void main(String[] args) {

    }

    // TC : theta(n)
    // SC : theta(n) auxiliary space
    private int trappingRainWater(int[] height) {

        int[] lMax = new int[height.length];
        int[] rMax = new int[height.length];

        lMax[0] = height[0];

        for (int i = 1; i < height.length; i++) {
            lMax[i] = Math.max(height[i], lMax[i - 1]);
        }

        rMax[rMax.length - 1] = height[height.length - 1];

        for (int i = rMax.length - 2; i >= 0; i--) {
            rMax[i] = Math.max(height[i], rMax[i + 1]);
        }

        int water = 0;
        for (int i = 1; i < height.length - 1; i++) {
            water += Math.min(lMax[i], rMax[i]) - height[i];
        }

        return water;
    }
}
