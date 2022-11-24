package com.neetcode.io;

public class MinimumIntervalToIncludeQuery {

    public int[] minInterval(int[][] intervals, int[] queries) {

        int[] res = new int[queries.length];


        for (int i = 0; i < queries.length; i++) {
            int smallestInterval = Integer.MAX_VALUE;

            for (int[] interval : intervals) {
                int start = interval[0];
                int end = interval[1];

                if (queries[i] >= start && queries[i] <= end) {
                    smallestInterval = Math.min(smallestInterval, end - start + 1);
                }

            }
            if (smallestInterval == Integer.MAX_VALUE) {
                res[i] = -1;
            } else {
                res[i] = smallestInterval;
            }
        }

        return res;
    }
}
