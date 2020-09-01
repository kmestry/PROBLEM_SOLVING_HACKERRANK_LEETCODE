package com.leetcode;

import java.util.HashMap;
import java.util.Map;

public class UniquePaths {

    Map<String, Integer> map = new HashMap<>();

    public int uniquePaths(int m, int n) {
        int row = n;
        int column = m;

        return helper(0, 0, row, column);
    }


    private int helper(int row, int column, int lastRow, int lastColumn) {

        if (row == lastRow - 1 && column == lastColumn - 1)
            return 1;

        String key = row + "@kun@" + column;
        if (map.containsKey(key))
            return map.get(key);

        int count = 0;
        if (row < lastRow && column < lastColumn) {
            count += helper(row, column + 1, lastRow, lastColumn);
            count += helper(row + 1, column, lastRow, lastColumn);
        }

        map.put(key, count);

        return count;

    }
}
