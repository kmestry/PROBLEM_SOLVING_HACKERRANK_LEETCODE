package com.leetcode;

import java.util.Arrays;
import java.util.Map;

public class HIndex {

    public static void main(String[] args) {

        new HIndex().hIndex(new int[]{3, 0, 6, 1, 5});
    }

    private static boolean test(Map.Entry<Integer, Integer> integerIntegerEntry) {
        return integerIntegerEntry.getValue() == integerIntegerEntry.getKey();
    }

    // [3,0,6,1,5]
    public int hIndex(int[] citations) {


        Arrays.sort(citations);

        int result = 0;

        for (int i = citations.length - 1; i >= 0; i--) {

            int min = Math.min(citations[i], citations.length - i);

            if (min > result)
                result = min;

        }
        return result;
    }
}
