package com.practise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntevals240222 {

    public static void main(String[] args) {

        //[[1,3],[2,6],[8,10],[15,18]]
        new MergeIntevals240222().merge(new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}});
    }


    public int[][] merge(int[][] intervals) {
        
        List<int[]> list = new ArrayList<>();

        if (intervals.length == 1) return intervals;
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));

        int r = 1;
        List<int[]> currList = new ArrayList<>();
        currList.add(intervals[0]);

        while (r < intervals.length) {
            if (intervals[r][0] <= currList.get(0)[1]) {
                int newL = currList.get(0)[0];
                int newR = Math.max(currList.get(0)[1], intervals[r][1]);
                currList.clear();
                currList.add(new int[]{newL, newR});
            } else {
                list.add(currList.get(0));
                currList.clear();
                currList.add(intervals[r]);
            }
            r++;
        }


        if (!currList.isEmpty())
            list.add(currList.get(0));

        int[][] result = new int[list.size()][];

        int index = 0;
        for (int[] arr : list) {
            result[index] = arr;
            index++;
        }

        return result;
    }
}
