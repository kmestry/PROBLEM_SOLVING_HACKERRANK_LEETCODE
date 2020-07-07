package com.leetcode;

public class IslandPerimeter463 {

    public static void main(String[] args) {
        int counter = islandPerimeter(new int[][]{{1}});
        System.out.println("counter = " + counter);
    }

    public static int islandPerimeter(int[][] grid) {


        int counter = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {

                if (grid[i][j] == 1) {
                    if (i == 0) {
                        counter++;
                    }
                    if (i == grid.length - 1) {
                        counter++;
                    }
                    if (j == 0) {
                        counter++;
                    }
                    if (j == grid[0].length - 1) {
                        counter++;
                    }
                    //horizontal
                 /*   if (j < grid.length - 1 && grid[i][j + 1] == 1) {
                        counter--;
                    }
                    if (j > 0 && grid[i][j - 1] == 1) {
                        counter--;
                    }*/
                    if (j > 0 && grid[i][j - 1] == 0) {
                        counter++;
                    }
                    if (j < grid[0].length - 1 && grid[i][j + 1] == 0) {
                        counter++;
                    }
                    //vertical
                  /*  if (i > 0 && grid[i - 1][j] == 1) {
                        counter--;
                    }
                    if (i < grid.length - 1 && grid[i + 1][j] == 1) {
                        counter--;
                    }*/
                    if (i < grid.length - 1 && grid[i + 1][j] == 0) {
                        counter++;
                    }
                    if (i > 0 && grid[i - 1][j] == 0) {
                        counter++;
                    }

                }

            }

        }
        return counter;
    }

}

