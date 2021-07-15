package com.blind_list_75.interval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {
    public int[][] merge(int[][] intervals) {

        List<int[]> list = new ArrayList<>();
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        int[] prev = intervals[0];

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= prev[0] && intervals[i][0] <= prev[1]) {
                prev[0] = Math.min(prev[0], intervals[i][0]);
                prev[1] = Math.max(prev[1], intervals[i][1]);
            } else if (intervals[i][0] > prev[1]) {
                list.add(prev);
                prev = intervals[i];
            }
        }

        list.add(prev);
        return list.toArray(new int[list.size()][]);
    }
}
