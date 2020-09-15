package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class InsertIntervals {

    public static void main(String[] args) {
        new InsertIntervals().insert(new int[][]{{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}}, new int[]{4, 8});
    }

    public int[][] insert(int[][] intervals, int[] newInterval) {

        List<int[]> list = new ArrayList<>();
        for (int[] in : intervals) {
            if (in[1] < newInterval[0]) {
                //extreme left no overlap.
                list.add(in);
            } else if (in[0] > newInterval[1]) {
                list.add(newInterval);
                newInterval = in;
            } else {
                newInterval[0] = Math.min(in[0], newInterval[0]);
                newInterval[1] = Math.max(in[1], newInterval[1]);
            }

        }
        list.add(newInterval);
        return list.toArray(new int[list.size()][]);
    }
}
