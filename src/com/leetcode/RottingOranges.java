package com.leetcode;

import java.util.*;

public class RottingOranges {


    public static void main(String[] args) {
        int result = new RottingOranges().orangesRotting(new int[][]{{2, 1, 1}, {1, 1, 0}, {0, 1, 1}});
        System.out.println("result = " + result);
    }

    public int orangesRotting(int[][] grid) {

        Set<List<Integer>> freshOrangeIndexes = new HashSet<>();
        Queue<List<Integer>> rottenOrangeQueue = new LinkedList<>();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    List<Integer> list = new ArrayList<>();
                    list.add(i);
                    list.add(j);
                    freshOrangeIndexes.add(list);
                } else if (grid[i][j] == 2) {
                    List<Integer> listRottenOranges = new ArrayList<>();
                    listRottenOranges.add(i);
                    listRottenOranges.add(j);
                    rottenOrangeQueue.offer(listRottenOranges);
                }
            }
        }

        //if no fresh oranges return 0
        if (freshOrangeIndexes.isEmpty())
            return 0;

        int minuteCounter = -1;
        while (!rottenOrangeQueue.isEmpty()) {

            int queueSize = rottenOrangeQueue.size();
            minuteCounter++;
            for (int i = 0; i < queueSize; i++) {
                List<Integer> rottenList = rottenOrangeQueue.poll();
                //travel in four directions. check adjacent.
                int row = rottenList.get(0);
                int column = rottenList.get(1);

                List<Integer> listToCheck = new ArrayList<>();
                listToCheck.add(row + 1);
                listToCheck.add(column);

                List<Integer> listToCheck1 = new ArrayList<>();
                listToCheck1.add(row - 1);
                listToCheck1.add(column);

                List<Integer> listToCheck2 = new ArrayList<>();
                listToCheck2.add(row);
                listToCheck2.add(column + 1);

                List<Integer> listToCheck3 = new ArrayList<>();
                listToCheck3.add(row);
                listToCheck3.add(column - 1);

                if (freshOrangeIndexes.contains(listToCheck)) {
                    rottenOrangeQueue.add(listToCheck);
                    freshOrangeIndexes.remove(listToCheck);
                }
                if (freshOrangeIndexes.contains(listToCheck1)) {
                    rottenOrangeQueue.add(listToCheck1);
                    freshOrangeIndexes.remove(listToCheck1);
                }
                if (freshOrangeIndexes.contains(listToCheck2)) {
                    rottenOrangeQueue.add(listToCheck2);
                    freshOrangeIndexes.remove(listToCheck2);
                }
                if (freshOrangeIndexes.contains(listToCheck3)) {
                    rottenOrangeQueue.add(listToCheck3);
                    freshOrangeIndexes.remove(listToCheck3);
                }

            }


        }

        if (freshOrangeIndexes.isEmpty()) {
            return minuteCounter;
        } else {
            return -1;
        }


    }
}
