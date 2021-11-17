package com.leetcode;

import java.util.*;

public class AllPathsFromSourceToTarget {

    public static void main(String[] args) {

        allPathsSourceTarget(new int[][]{{1, 2}, {3}, {1, 3}, {}});
    }

    //[[1,2],[3],[1,3],[]]

    public static List<List<Integer>> allPathsSourceTarget(int[][] graph) {

        List<List<Integer>> result = new ArrayList<>();
        int startPosition = 0;
        int goal = graph.length - 1;
        Queue<List<Integer>> listQueue = new LinkedList<>();
        listQueue.add(Arrays.asList(startPosition)); // need to add 0 as a list as it is the start position.

        while (!listQueue.isEmpty()) {
            List<Integer> integerList = listQueue.poll();

            if (integerList.get(integerList.size() - 1) == goal) {
                result.add(integerList);
            }


            int graphIndex = integerList.get(integerList.size() - 1);
            int[] graphArray = graph[graphIndex];
            for (int j : graphArray) {
                List<Integer> innerList = new ArrayList<>(integerList);
                innerList.add(j);
                listQueue.add(innerList);
            }

        }

        return result;
    }
}
