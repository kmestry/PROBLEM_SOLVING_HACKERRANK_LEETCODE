package com.leetcode;

import java.util.Arrays;

public class HeightChecker {

    public static void main(String[] args) {
        int result = heightChecker(new int[]{1, 1, 4, 2, 1, 3});
        System.out.println("result = " + result);
    }

    public static int heightChecker(int[] heights) {

        int[] initialArray = new int[heights.length];
        for (int i = 0; i < initialArray.length; i++) {
            initialArray[i] = heights[i];
        }
        Arrays.sort(heights);


        int counter = 0;
        for (int i = 0; i < heights.length; i++) {
            if (initialArray[i] != heights[i]) {
                counter++;
            }
        }

        return counter;
    }

}
