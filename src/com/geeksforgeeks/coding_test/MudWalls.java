package com.geeksforgeeks.coding_test;

import java.util.Arrays;
import java.util.List;

public class MudWalls {


    public static void main(String[] args) {
        MudWalls mudWalls = new MudWalls();
        mudWalls.maxHeight(Arrays.asList(1, 3, 7), Arrays.asList(4, 3, 3));
    }

    public int maxHeight(List<Integer> wallPositions, List<Integer> wallHeights) {
        int n = wallPositions.size();
        int max = 0;

        for (int i = 0; i < n - 1; i++) {
            if (wallPositions.get(i) < wallPositions.get(i + 1) - 1) {
                // We have a gap
                int heightDifference = Math.abs(wallHeights.get(i + 1) - wallHeights.get(i));
                int gapLength = wallPositions.get(i + 1) - wallPositions.get(i) - 1;
                int localMax;
                if (gapLength > heightDifference) {
                    int low = Math.max(wallHeights.get(i + 1), wallHeights.get(i)) + 1;
                    int remainingGap = gapLength - heightDifference - 1;
                    localMax = low + remainingGap / 2;

                } else {
                    localMax = Math.min(wallHeights.get(i + 1), wallHeights.get(i)) + gapLength;
                }

                max = Math.max(max, localMax);
            }
        }

        return max;
    }
}
