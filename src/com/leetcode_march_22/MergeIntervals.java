package com.leetcode_march_22;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {

    public static void main(String[] args) {
        new MergeIntervals().merge(new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}});
        // new MergeIntervals().merge(new int[][]{{1, 4}, {4, 5}});
    }

    public int[][] merge(int[][] intervals) {

        Arrays.sort(intervals, (o1, o2) -> o1[0] - o2[0]);
        List<int[]> res = new ArrayList<>();

        List<Integer> holderList = new ArrayList<>(2);

        int l = 0;
        int r = 1;

        while (r < intervals.length) {
            int[] right = intervals[r];

            if (!holderList.isEmpty()) {
                int hL = holderList.get(0);
                int hR = holderList.get(1);
                if (right[0] <= hR) {
                    holderList.clear();
                    holderList.add(Math.min(hL, right[0]));
                    holderList.add(Math.max(hR, right[1]));
                } else {
                    res.add(new int[]{hL, hR});
                    holderList.clear();
                }
            } else {
                int[] left = intervals[l];
                if (right[0] <= left[1]) {
                    holderList.add(Math.min(left[0], right[0]));
                    holderList.add(Math.max(left[1], right[1]));
                } else {
                    res.add(new int[]{left[0], left[1]});
                }

            }
            l++;
            r++;


        }
        if (!holderList.isEmpty()) res.add(new int[]{holderList.get(0), holderList.get(1)});
        else res.add(new int[]{intervals[l][0], intervals[l][1]});
        return res.toArray(new int[0][]);

    }
}
