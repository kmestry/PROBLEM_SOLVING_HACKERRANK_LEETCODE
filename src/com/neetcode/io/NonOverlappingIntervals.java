package com.neetcode.io;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class NonOverlappingIntervals {

    public static void main(String[] args) {
        new NonOverlappingIntervals().eraseOverlapIntervals(new int[][]{{0, 2}, {1, 3}, {2, 4}, {3, 5}, {4, 6}});

    }

    public int eraseOverlapIntervals(int[][] intervals) {

        Arrays.sort(intervals, (o1, o2) -> o1[1] - o2[1]);

        int l = 0;
        int r = l + 1;
        int numOfIntervalsRemoved = 0;
        Set<Integer> visited = new HashSet<>();
        while (r < intervals.length) {
            if (visited.contains(l)) {
                l++;
                continue;
            }
            if (intervals[r][0] >= intervals[l][1]) {
                l++;
                r++;
            } else {
                visited.add(r);
                numOfIntervalsRemoved++;
                r++;
            }
        }

        return numOfIntervalsRemoved;


    }
}
