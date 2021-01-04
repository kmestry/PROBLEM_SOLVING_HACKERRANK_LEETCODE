package com.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CheckArrayFormation {


    public static void main(String[] args) {
        new CheckArrayFormation().canFormArray(new int[]{91, 4, 64, 78}, new int[][]{{78}, {4, 64}, {91}});
    }


    public boolean canFormArray(int[] arr, int[][] pieces) {
        Map<Integer, int[]> map = new HashMap<>();

        for (int[] piece : pieces) {
            map.put(piece[0], piece);
        }

        int[] result = new int[arr.length];
        int index = 0;
        for (int ele : arr) {
            if (map.containsKey(ele)) {
                int[] array = map.get(ele);
                for (int i = 0; i < array.length && index < result.length; i++) {
                    result[index] = array[i];
                    index++;
                }
            }

        }
        return Arrays.equals(result, arr);
    }
}
