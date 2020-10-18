package com.leetcode;

// 3
// [[1,0],[2,1]]

import java.util.ArrayDeque;
import java.util.Deque;

//1 --> 2
public class CourseSchedule {

    public static void main(String[] args) {
        new CourseSchedule().canFinish(3, new int[][]{{1, 0}, {2, 1}});
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {


        int[] inDegree = new int[numCourses];


        for (int[] prerequisite : prerequisites) {
            inDegree[prerequisite[0]]++;
        }

        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == 0) {
                stack.push(i);
            }
        }
        int count = 0;
        while (!stack.isEmpty()) {
            int zeroInDegreeElement = stack.pop();
            count++;

            for (int[] prerequisite : prerequisites) {
                if (prerequisite[1] == zeroInDegreeElement) {
                    inDegree[prerequisite[0]]--;
                    if (inDegree[prerequisite[0]] == 0) {
                        stack.push(prerequisite[0]);
                    }
                }
            }
        }

        return count == numCourses;

    }
}



