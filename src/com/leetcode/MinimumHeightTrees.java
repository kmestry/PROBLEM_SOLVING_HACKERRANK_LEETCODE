package com.leetcode;

import java.util.*;

public class MinimumHeightTrees {

    public static void main(String[] args) {
        new MinimumHeightTrees().findMinHeightTrees(4, new int[][]{{1, 0}, {1, 2}, {1, 3}});
    }

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {

        List<Integer> resultList = new ArrayList<>();

        if (n == 0) {
            return resultList;
        }

        if (n == 1) {
            resultList.add(0);
            return resultList;
        }

        Map<Integer, Set<Integer>> graph = new HashMap<>();
        //initialize graph

        for (int i = 0; i < n; i++) {
            graph.put(i, new HashSet<>());
        }

        int[] degree = new int[n];

        //create adjaceny list/graph.
        for (int i = 0; i < edges.length; i++) {
            int left = edges[i][0];
            int right = edges[i][1];

            degree[left]++;
            degree[right]++;
            graph.get(left).add(right);
            graph.get(right).add(left);

        }
        Queue<Integer> queue = new LinkedList<>();
        //add indegree 1 elements to queue.
        for (int i = 0; i < degree.length; i++) {
            if (degree[i] == 1) {
                queue.offer(i);
            }
        }

        //BFS
        while (!queue.isEmpty()) {
            resultList = new ArrayList<>();
            int queueSize = queue.size();

            for (int i = 0; i < queueSize; i++) {
                int current = queue.poll();
                resultList.add(current);
                Set<Integer> set = graph.get(current);

                for (Integer val : set) {
                    degree[val]--;
                    if (degree[val] == 1) {
                        queue.offer(val);
                    }
                }

            }

        }

        return resultList;

    }
}
