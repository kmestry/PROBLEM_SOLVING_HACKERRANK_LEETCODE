package com.leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class MinimumNumberOfArrowsToBurstBalloons {

    public static void main(String[] args) {
        //[[10,16], [2,8], [1,6], [7,12]]
        //{{3,9},{7,12},{3,8},{6,8},{9,10},{2,9},{0,9},{3,9},{0,6},{2,8}}
        //new MinimumNumberOfArrowsToBurstBalloons().findMinArrowShots(new int[][]{{10, 16}, {2, 8}, {1, 6}, {7, 12}});
        //new MinimumNumberOfArrowsToBurstBalloons().findMinArrowShots(new int[][]{{2, 3}, {2, 3}});
        new MinimumNumberOfArrowsToBurstBalloons().findMinArrowShots(new int[][]{{3, 9}, {7, 12}, {3, 8}, {6, 8}, {9, 10}, {2, 9}, {0, 9}, {3, 9}, {0, 6}, {2, 8}});
    }

    public int findMinArrowShots(int[][] points) {


        if (points.length == 0)
            return 0;

        if (points.length < 2) {
            return 1;
        }

        Arrays.sort(points, Comparator.comparingInt(o -> o[1]));

        int arrowPosition = points[0][1];
        int pointer = 0;
        int minimumArrowsRequired = 0;
        boolean isTransitionOfArrowPointerDone = false;
        boolean isVisited = false;

        while (pointer < points.length) {

            if (arrowPosition >= points[pointer][0] && arrowPosition <= points[pointer][1]) {
                isVisited = true; // all balloons burst with 1 arrow.
                pointer++;
            } else {
                isTransitionOfArrowPointerDone = true;
                minimumArrowsRequired++;
                arrowPosition = points[pointer][1];
            }


        }

        if (isVisited && minimumArrowsRequired == 0)
            return 1;

        return isTransitionOfArrowPointerDone ? minimumArrowsRequired + 1 : minimumArrowsRequired;

    }
}
