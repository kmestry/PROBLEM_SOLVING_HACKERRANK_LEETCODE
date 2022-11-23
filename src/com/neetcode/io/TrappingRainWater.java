package com.neetcode.io;

public class TrappingRainWater {

    public int trap(int[] height) {

        int[] left = new int[height.length];
        int[] right = new int[height.length];

        int currMax = height[0];

        for (int i = 0; i < height.length; i++) {
            left[i] = currMax;
            currMax = Math.max(currMax, height[i]);
        }

        right[right.length - 1] = height[height.length - 1];

        currMax = height[height.length - 1];

        for (int i = height.length - 1; i >= 0; i--) {
            right[i] = currMax;
            currMax = Math.max(currMax, height[i]);
        }

        int res = 0;

        for (int i = 0; i < height.length; i++) {
            int water = Math.min(left[i], right[i]) - height[i];
            if (water > 0) res += water;
        }

        return res;
    }

}
