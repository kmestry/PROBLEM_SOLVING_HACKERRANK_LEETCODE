package com.leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class NonOverlappingIntervals {

    public static void main(String[] args) {

        new NonOverlappingIntervals().eraseOverlapIntervals(new int[][]{{1, 100}, {11, 22}, {1, 11}, {2, 12}});
    }

    //[[1,2],[2,3],[3,4],[1,3]]
    public int eraseOverlapIntervals(int[][] intervals) {

        int counter = 0;
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[1]));
        int index = 0;
        int[] compareArray = intervals[index];

        for (int i = 1; i < intervals.length; i++) {
            int[] innerArray = intervals[i];


            if (innerArray[0] < compareArray[1]) {
                counter++;
            } else {
                index = i;
                compareArray = intervals[index];

            }
        }
        return counter;
    }
}

