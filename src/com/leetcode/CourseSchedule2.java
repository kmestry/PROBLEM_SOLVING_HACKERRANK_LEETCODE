package com.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class CourseSchedule2 {


    public static void main(String[] args) {
        findOrder(4, new int[][]{{1, 0}, {2, 0}, {3, 1}, {3, 2}});
    }

    //2
    //[[0,1],[1,0]]
    //4, [[1,0],[2,0],[3,1],[3,2]]
    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] topSort = new int[numCourses];
        Map<Integer, List<Integer>> mapOfCourse = new HashMap<>();

        for (int i = 0; i < prerequisites.length; i++) {

            if (mapOfCourse.containsKey(prerequisites[i][1])) {
                List<Integer> integerList = mapOfCourse.get(prerequisites[i][1]);
                integerList.add(prerequisites[i][0]);
                mapOfCourse.put(prerequisites[i][1], integerList);

            } else {
                List<Integer> list = new ArrayList<>();
                list.add(prerequisites[i][0]);
                mapOfCourse.put(prerequisites[i][1], list);
            }

        }

        boolean[] visited = new boolean[numCourses];
        boolean[] recStack = new boolean[numCourses];
        Stack<Integer> stack = new Stack();

        for (int i = 0; i < numCourses; i++) {
            if (visited[i] == false) {
                boolean cyclePresent = dfs(mapOfCourse, visited, i, stack, recStack);
                if (cyclePresent) return new int[0];
            }
        }

        for (int i = 0; i < numCourses; i++)
            topSort[i] = stack.pop();

        return topSort;
    }

    private static boolean dfs(Map<Integer, List<Integer>> graph, boolean[] visited, int start, Stack<Integer> stack, boolean[] recStack) {
        visited[start] = true;
        recStack[start] = true;
        List<Integer> neighbours = graph.get(start);
        if (neighbours != null) {
            for (int node : neighbours) {
                if (!visited[node] && dfs(graph, visited, node, stack, recStack)) {
                    return true;
                } else {
                    if (recStack[node]) return true;
                }
            }
        }
        recStack[start] = false;
        stack.push(start);
        return false;
    }
}


