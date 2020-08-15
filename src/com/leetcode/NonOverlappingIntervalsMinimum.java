package com.leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class NonOverlappingIntervalsMinimum {


    public static void main(String[] args) {

        //[[1, 2],[1, 3],[2, 3],[3, 4],]
        // 1, 100}, {11, 22}, {1, 11}, {2, 12}
        // 1 11  , 1 100, 2 12 ,  11 22
        new NonOverlappingIntervalsMinimum().eraseOverlapIntervals(new int[][]{{1, 100}, {11, 22}, {1, 11}, {2, 12}});

    }

    public int eraseOverlapIntervals(int[][] intervals) {

        if (intervals.length < 2) {
            return 0;
        }


        int minimumIntervalsToErase = 0;
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[1]));

        int leftPointer = 0;
        int rightPointer = leftPointer + 1;

        while (rightPointer < intervals.length) {


            int[] firstInnerArray = intervals[leftPointer];
            int[] secondInnerArray = intervals[rightPointer];

            if (secondInnerArray[0] < firstInnerArray[1]) {
                rightPointer++;
                minimumIntervalsToErase++;
            } else {
                leftPointer = rightPointer;
                rightPointer++;
            }


        }

        return minimumIntervalsToErase;

    }
}
