package com.leetcode;

import java.util.HashMap;
import java.util.Map;

public class MinimumFallingPathSum {

    Map<String, Integer> map = new HashMap<>();

    public int minFallingPathSum(int[][] A) {

        int result = Integer.MAX_VALUE;
        for (int i = 0; i < A[0].length; i++) {
            result = Math.min(result, helper(0, i, A));
        }

        return result;

    }

    private int helper(int row, int col, int[][] array) {

        if (row == array.length) {
            return 0;
        }


        if (col < 0 || col >= array[0].length) {
            return Integer.MAX_VALUE;
        }
        String key = row + "&" + col;

        if (map.containsKey(key))
            return map.get(key);

        int path1 = helper(row + 1, col, array);
        int path2 = helper(row + 1, col - 1, array);
        int path3 = helper(row + 1, col + 1, array);

        int min = Math.min(path1, Math.min(path2, path3));
        int result = array[row][col] + min;
        map.put(key, result);
        return result;
    }
}
