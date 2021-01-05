package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LargestRectangleInHistogram {

    public static void main(String[] args) {
        new LargestRectangleInHistogram().largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3});
    }

    public int largestRectangleArea(int[] heights) {
        int maxArea = 0;
        List<int[]> stack = new ArrayList<>(); // list of pair: [index, height]

        for (int i = 0; i < heights.length; i++) {
            int start = i;

            while (stack.size() > 0 && stack.get(stack.size() - 1)[1] > heights[i]) {
                int height = stack.get(stack.size() - 1)[1];
                int width = i - stack.get(stack.size() - 1)[0];
                maxArea = Math.max(maxArea, height * width);
                start = stack.get(stack.size() - 1)[0];
                stack.remove(stack.size() - 1);
            }
            stack.add(new int[]{start, heights[i]});
        }
        for (int i = 0; i < stack.size(); i++) {
            int height = stack.get(i)[1], start = stack.get(i)[0];
            int area = height * (heights.length - start);
            maxArea = Math.max(area, maxArea);
        }
        return maxArea;
    }
}
