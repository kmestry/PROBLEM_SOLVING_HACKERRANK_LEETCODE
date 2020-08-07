package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {

    public static void main(String[] args) {

        new MergeIntervals().merge(new int[][]{{2, 3}, {2, 2}, {3, 3}, {1, 3}, {5, 7}, {2, 2}, {4, 6}});
    }


    //  [[1,3],[2,6],[8,10],[15,18]]
    public int[][] merge(int[][] intervals) {

        if (intervals.length <= 1) {
            return intervals;
        }

        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        List<int[]> resultList = new ArrayList<>();

        resultList.add(intervals[0]);

        for (int i = 1; i < intervals.length; i++) {
            int currentLeftElement = intervals[i][0];
            int currentRightElement = intervals[i][1];

            int[] firstResultTuple = resultList.get(resultList.size() - 1);

            if (currentLeftElement <= firstResultTuple[1]) {
                firstResultTuple[1] = Math.max(currentRightElement, firstResultTuple[1]);
            } else {
                resultList.add(new int[]{currentLeftElement, currentRightElement});

            }

        }


        int[][] result = new int[resultList.size()][];

        int indexCounter = 0;
        for (int i = 0; i < result.length; i++) {

            result[i] = resultList.get(indexCounter);
            indexCounter++;

        }

        return result;

    }
}
