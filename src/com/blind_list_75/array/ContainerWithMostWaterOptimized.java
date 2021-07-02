package com.blind_list_75.array;

public class ContainerWithMostWaterOptimized {

    public int maxArea(int[] height) {

        //3 9 3 4 7 2 12 6

        int maxArea = Integer.MIN_VALUE;
        int lo = 0;
        int hi = height.length - 1;

        while (lo < hi) {
            int dist = hi - lo;
            boolean isLowLesser = height[lo] < height[hi];

            maxArea = Math.max(maxArea, dist * Math.min(height[lo], height[hi]));

            if (isLowLesser) {
                while (lo < hi && height[lo + 1] < height[lo]) lo++;
                lo++;
            } else {
                while (lo < hi && height[hi - 1] < height[hi]) hi--;
                hi--;
            }
        }

        return maxArea;

    }
}
