package com.geeksforgeeks.arrays.practise;

public class TrappingRainWater {

    public static void main(String[] args) {
        TrappingRainWater trappingRainWater = new TrappingRainWater();
        int result = trappingRainWater.trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1});
        System.out.println("result = " + result);
    }

    public int trap(int[] height) {

        int[] lmax = new int[height.length];
        int[] rmax = new int[height.length];

        lmax[0] = height[0];
        rmax[rmax.length - 1] = height[height.length - 1];


        for (int i = 1; i < height.length; i++) {
            lmax[i] = Math.max(height[i], lmax[i - 1]);
        }

        for (int i = rmax.length - 2; i >= 0; i--) {
            rmax[i] = Math.max(height[i], rmax[i + 1]);
        }

        int water = 0;
        for (int i = 1; i < height.length - 1; i++) {
            water += Math.min(lmax[i], rmax[i]) - height[i];
        }

        return water;
    }
}
