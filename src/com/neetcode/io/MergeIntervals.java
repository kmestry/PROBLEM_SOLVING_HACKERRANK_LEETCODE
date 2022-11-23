package com.neetcode.io;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {

    public int[][] merge(int[][] intervals) {

        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));

        List<int[]> res = new ArrayList<>();

        int start = intervals[0][0];
        int end = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            int currStart = intervals[i][0];
            int currEnd = intervals[i][1];

            if (currStart <= end) {
                start = Math.min(start, currStart);
                end = Math.max(end, currEnd);
            } else {
                res.add(new int[]{start, end});
                start = currStart;
                end = currEnd;
            }

        }

        res.add(new int[]{start, end});

        return res.toArray(new int[res.size()][2]);
    }
}
