package com.leetcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class SkylineProblem {

    public static void main(String[] args) {
        List<List<Integer>> res = new SkylineProblem().getSkyline(new int[][]{{2, 9, 10}, {3, 7, 15}, {5, 12, 12}, {15, 20, 10}, {19, 24, 8}});
        System.out.println("res = " + res);
    }


    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<List<Integer>> result = new ArrayList<>();
        List<int[]> heights = new ArrayList<>();
        transform(heights, buildings);
        heights.sort((o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o1[0] - o2[0]);


        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Comparator.reverseOrder());
        priorityQueue.offer(0);

        int preMax = 0;
        for (int[] height : heights) {
            if (height[1] < 0) {
                priorityQueue.offer(-height[1]);
            } else {
                priorityQueue.remove(height[1]);
            }
            Integer currMax = priorityQueue.peek();

            if (preMax != currMax) {
                List<Integer> subResult = new ArrayList<>();
                subResult.add(height[0]);
                subResult.add(currMax);
                result.add(subResult);
                preMax = currMax;
            }
        }
        return result;
    }

    private void transform(List<int[]> heights, int[][] buildings) {

        for (int[] arr : buildings) {
            heights.add(new int[]{arr[0], -arr[2]});
            heights.add(new int[]{arr[1], arr[2]});
        }
    }
}
