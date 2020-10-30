package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class MaximumDistanceToClosestPersonOptimized {

    public int maxDistToClosest(int[] seats) {

        List<Integer> list = new ArrayList<>();


        boolean isCaseLeftZero = false;
        boolean isCaseRightZero = false;
        boolean isCaseLRZero = false;
        for (int i = 0; i < seats.length; i++) {
            if (seats[i] == 1) {
                list.add(i);  // [0 , 4, 6]
            }
        }

        final int arraySize = seats.length - 1;
        if (seats[0] == 0 && seats[arraySize] == 0) {
            isCaseLRZero = true;
        } else if (seats[0] == 0) {
            isCaseLeftZero = true;
        } else if (seats[arraySize] == 0) {
            isCaseRightZero = true;
        }


        int maxDistance = Integer.MIN_VALUE;
        final Integer firstListElement = list.get(0);
        if (list.size() == 1) {
            return Math.max(firstListElement, Math.max(Math.abs(firstListElement - arraySize), maxDistance));
        } else {
            //[2,4,5]
            for (int i = 0; i < list.size() - 1; i++) {
                int mid = (list.get(i) + list.get(i + 1)) / 2;
                maxDistance = Math.max(maxDistance, Math.abs(list.get(i) - mid));
            }
            //[0,0,1,0,1,1,0,0]
            final Integer lastElementList = list.get(list.size() - 1);
            final int distanceFromLastOneToLastZeroInOriginalArray = Math.max(Math.abs(lastElementList - arraySize), maxDistance);
            if (isCaseLRZero) {
                return Math.max(firstListElement,
                        distanceFromLastOneToLastZeroInOriginalArray);
            } else if (isCaseLeftZero) {
                return Math.max(firstListElement, maxDistance);
            } else if (isCaseRightZero) {
                return distanceFromLastOneToLastZeroInOriginalArray;
            } else {
                return maxDistance;
            }

        }

    }
}
