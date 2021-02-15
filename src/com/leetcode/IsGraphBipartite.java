package com.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class IsGraphBipartite {

    public static void main(String[] args) {
        IsGraphBipartite isGraphBipartite = new IsGraphBipartite();
        isGraphBipartite.isBipartite(new int[][]{{1, 3}, {0, 2}, {1, 3}, {0, 2}});
    }

    public boolean isBipartite(int[][] graph) {

        int[] color = new int[graph.length];
        int length = graph.length;

        for (int i = 0; i < graph.length; i++) {
            if (color[i] != 0) continue;
            Queue<Integer> queue = new LinkedList<>();
            queue.offer(i);
            color[i] = 1;

            while (!queue.isEmpty()) {
                int currNode = queue.poll();
                for (int next : graph[currNode]) {

                    if (color[next] == 0) {
                        color[next] = -color[currNode];
                        queue.offer(next);
                    }

                    if (color[next] == color[currNode]) return false;
                }
            }
        }

        return true;
    }
}
