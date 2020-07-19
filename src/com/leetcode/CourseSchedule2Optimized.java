package com.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class CourseSchedule2Optimized {


    public static void main(String[] args) {
        findOrder(3, new int[][]{{1, 0}, {1, 2}, {0, 1}});
    }

    //2
    //[[0,1],[1,0]]
    //4, [[1,0],[2,0],[3,1],[3,2]]
    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer> result = new ArrayList<>();
        Map<Integer, Integer> indegreeMap = new HashMap<>();
        Map<Integer, List<Integer>> mapOfCourse = new HashMap<>();

        for (int i = 0; i < prerequisites.length; i++) {

            if (indegreeMap.containsKey(prerequisites[i][0])) {
                indegreeMap.put(prerequisites[i][0], indegreeMap.get(prerequisites[i][0]) + 1);
            } else {
                indegreeMap.put(prerequisites[i][0], 1);
            }

        }

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
            List<Integer> integerListMap = mapOfCourse.get(prerequisite);
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


