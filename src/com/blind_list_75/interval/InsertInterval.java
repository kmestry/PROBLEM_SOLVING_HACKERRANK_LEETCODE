package com.blind_list_75.interval;

import java.util.ArrayList;
import java.util.List;

public class InsertInterval {

    public static void main(String[] args) {
        InsertInterval insertInterval = new InsertInterval();
        int[][] result = insertInterval.insert(new int[][]{{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}}, new int[]{4, 8});
        //int[][] result = insertInterval.insert(new int[][]{{1, 5}}, new int[]{6, 8});
        System.out.println(result);
    }

    public int[][] insert(int[][] intervals, int[] newInterval) {

        List<int[]> list = new ArrayList<>();
        for (int[] arr : intervals) {

            if (arr[1] < newInterval[0]) {
                list.add(arr);
            } else if (arr[0] > newInterval[1]) {
                list.add(newInterval);
                newInterval = arr;
            } else {
                newInterval[0] = Math.min(arr[0], newInterval[0]);
                newInterval[1] = Math.max(arr[1], newInterval[1]);
            }
        }

        list.add(newInterval);
        int[][] result = new int[list.size()][];

        int index = 0;
        for (int[] arr : list) {
            result[index] = arr;
            index++;
        }

        return result;
    }


}
