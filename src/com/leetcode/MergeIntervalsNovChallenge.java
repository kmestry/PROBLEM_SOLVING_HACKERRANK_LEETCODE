package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervalsNovChallenge {

    public static void main(String[] args) {
        new MergeIntervalsNovChallenge().merge(new int[][]{{1, 4}, {0, 4}});
    }


    public int[][] merge(int[][] intervals) {

        //  System.out.println(intervals.length);
        // System.out.println(intervals[0].length);
        List<int[]> list = new ArrayList<>();

        Arrays.sort(intervals, Comparator.comparingInt(i -> i[0]));

        // for(int i = 0; i < intervals.length; i++){
        //     System.out.println(intervals[i][0] + "--" + intervals[i][1]);
        // }

        int[] prev = intervals[0];


        for (int i = 1; i < intervals.length; i++) {
            int[] current = intervals[i];

            if (prev[1] >= current[0]) {
                prev[0] = prev[0];
                prev[1] = Math.max(current[1], prev[1]);

            } else {
                list.add(new int[]{prev[0], prev[1]});
                prev[0] = current[0];
                prev[1] = current[1];
            }

        }
        list.add(new int[]{prev[0], prev[1]});


        int[][] result = new int[list.size()][2];

        int index = 0;
        for (int[] i : list) {
            result[index] = i;
            index++;
        }

        return result;

    }
}
