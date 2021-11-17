package com.leetcode;

import java.util.*;

public class CourseSchedule2Optimized {


/*
    Node having indegree of 0 will always be first in the topological order.

    Maintain hashmap having indegree count of every node or vertex.
    Maintain hashmap having outdegree edges going from every node or vertex.
    Maintain queue to add every node or vertex to it having indegree 0.
    To understand topological sort watch this https://www.youtube.com/watch?v=dis_c84ejhQ . very helpful to get intuition of the problem.
    If the output array contains less element than numCourse return empty array else return result array.


*/

    public static void main(String[] args) {
        findOrder(3, new int[][]{{1, 0}, {2, 0}, {3, 1}, {3, 2}});
    }

    //2
    //[[0,1],[1,0]]
    //4, [[1,0],[2,0],[3,1],[3,2]]
    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer> result = new ArrayList<>();
        Map<Integer, Integer> indegreeMap = new HashMap<>();
        Map<Integer, List<Integer>> outDegreeEdgesMap = new HashMap<>();

        for (int i = 0; i < prerequisites.length; i++) {

            if (indegreeMap.containsKey(prerequisites[i][0])) {
                indegreeMap.put(prerequisites[i][0], indegreeMap.get(prerequisites[i][0]) + 1);
            } else {
                indegreeMap.put(prerequisites[i][0], 1);
            }

        }

        //outdegree.....
        for (int i = 0; i < prerequisites.length; i++) {

            if (outDegreeEdgesMap.containsKey(prerequisites[i][1])) {
                List<Integer> integerList = outDegreeEdgesMap.get(prerequisites[i][1]);
                integerList.add(prerequisites[i][0]);
                outDegreeEdgesMap.put(prerequisites[i][1], integerList);

            } else {
                List<Integer> list = new ArrayList<>();
                list.add(prerequisites[i][0]);
                outDegreeEdgesMap.put(prerequisites[i][1], list);
            }

        }
        for (int i = 0; i < numCourses; i++) {
            if (!indegreeMap.containsKey(i)) {
                indegreeMap.put(i, 0);
            }
        }

        // Initialize queue and add all courses having indegree 0
        Queue<Integer> queue = new LinkedList();
        for (int i = 0; i < numCourses; i++) {
            if (indegreeMap.get(i) == 0) {
                queue.add(i);
                //order[index++] = i;
            }
        }
//4, [[1,0],[2,0],[3,1],[3,2]]
        while (!queue.isEmpty()) {
            int prerequisite = queue.poll();
            List<Integer> integerListMap = outDegreeEdgesMap.get(prerequisite);
            if (integerListMap != null) {
                for (Integer value : integerListMap) {
                    int counter = indegreeMap.get(value);
                    indegreeMap.put(value, counter - 1);
                    if (indegreeMap.get(value) == 0) {
                        queue.offer(value);
                    }

                }
            }
            result.add(prerequisite);

        }


        return result.size() == numCourses ? result.stream().mapToInt(value -> value).toArray() : new int[]{};

    }

}


