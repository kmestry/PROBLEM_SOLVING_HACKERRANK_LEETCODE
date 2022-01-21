package com.datastructure_2_studyplan_leetcode.day2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {

    public static void main(String[] args) {
        new MergeIntervals().merge(new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}});
    }


    public int[][] merge(int[][] intervals) {

        List<int[]> result = new ArrayList<>();
        result.add(intervals[0]);

        //System.out.println(result);
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));

        for (int i = 1; i < intervals.length; i++) {
            int[] curr = intervals[i];
            int[] prev = result.get(result.size() - 1);

            if (curr[0] <= prev[1]) {
                int[] merged = new int[2];
                merged[0] = prev[0];
                merged[1] = curr[1];

                result.remove(result.size() - 1);
                result.add(merged);
            } else {
                result.add(curr);
            }
        }

        //System.out.println(result);
        int[][] res = new int[result.size()][];

        return result.toArray(res);


    }
}
