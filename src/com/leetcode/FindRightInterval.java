package com.leetcode;

import java.util.TreeMap;

public class FindRightInterval {

    public static void main(String[] args) {
        int[] result = new FindRightInterval().findRightIntervalTreeMap(new int[][]{{1, 2}, {2, 3}, {0, 1}, {3, 4}});

        for (int i : result) {
            System.out.print(i + " ");
        }
    }

    public int[] findRightInterval(int[][] intervals) {

        int[] result = new int[intervals.length];

        //[ [3,4], [2,3], [1,2] ]

        for (int i = 0; i < intervals.length; i++) {

            int[] input = intervals[i];
            int left = input[0];
            int right = input[1];


            int minRight = -1;
            int lowestInterval = Integer.MAX_VALUE;

            for (int j = 0; j < intervals.length; j++) {
                if (j != i) {
                    int[] compare = intervals[j];
                    int leftCompare = compare[0];
                    int rightCompare = compare[1];


                    if (leftCompare >= right) {
                        if (leftCompare < lowestInterval) {

                            lowestInterval = leftCompare;
                            minRight = j;
                        }
                    }

                }
            }

            if (lowestInterval != Integer.MAX_VALUE) {

                result[i] = minRight;

            } else {
                result[i] = -1;
            }


        }

        return result;

    }

    public int[] findRightIntervalTreeMap(int[][] intervals) {


        TreeMap<Integer, Integer> map = new TreeMap<>();

        for (int i = 0; i < intervals.length; i++) {
            int[] array = intervals[i];

            map.put(array[0], i);

        }

        int[] result = new int[intervals.length];

        for (int i = 0; i < intervals.length; i++) {
            int[] array = intervals[i];
            int val = -1;
            try {
                val = map.ceilingKey(array[1]);
            } catch (NullPointerException e) {
                result[i] = -1;
                continue;
            }
            int index = map.get(val);

            result[i] = index;

        }

        return result;
    }
}
