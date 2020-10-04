package com.leetcode;

public class RemoveCoveredIntervals {

    public int removeCoveredIntervals(int[][] intervals) {

        int count = 0;
        for (int i = 0; i < intervals.length; i++) {

            int a = intervals[i][0];
            int b = intervals[i][1];

            for (int j = 0; j < intervals.length; j++) {

                int c = intervals[j][0];
                int d = intervals[j][1];

                if (i != j && c <= a && b <= d) {
                    count++;
                    break;  // important step.!!
                    //interval[c,d) is the inner loop. as we found out Interval [a,b) (outer loop)
                    // is covered by interval [c,d).
                    //we need to break the inner loop and check the next [a,b).
                }

            }
        }

        return intervals.length - count;
    }
}
