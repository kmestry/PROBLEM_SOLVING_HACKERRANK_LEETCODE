package com.leetcode;


import java.util.*;
import java.util.stream.Collectors;

public class KWeakestRows {

    public static void main(String[] args) {
        new KWeakestRows().kWeakestRows(new int[][]{
                {1, 1, 0, 0, 0},
                {1, 1, 1, 1, 0},
                {1, 0, 0, 0, 0},
                {1, 1, 0, 0, 0},
                {1, 1, 1, 1, 1}
        }, 3);
    }

    public int[] kWeakestRows(int[][] mat, int k) {

        Map<Integer, Integer> map = new TreeMap<>();
        int row = mat.length;
        int col = mat[0].length;
        for (int i = 0; i < row; i++) {
            int oneCounter = 0;
            for (int j = 0; j < col; j++) {
                int val = mat[i][j];
                if (val == 1) {
                    oneCounter++;
                } else {
                    break;
                }
            }
            map.put(i, oneCounter);
        }


        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        List<Map.Entry<Integer, Integer>> sortedList = list.stream().
                sorted(Comparator.comparingInt(Map.Entry::getValue)).collect(Collectors.toList());

        int[] result = new int[k];
        int index = 0;
        for (Map.Entry<Integer, Integer> entry : sortedList) {
            if (index >= k) break;
            result[index] = entry.getKey();
            index++;
        }

        return result;

    }
}
