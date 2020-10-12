package com.hackerrank.hackerfest.october10;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//greedily choose non-duplicate element everytime : intuition.
public class StrictlyIncreasingSequence {

    public static final String FIRST = "First";
    public static final String SECOND = "Second";

    public static void main(String[] args) {
        String result = StrictlyIncreasingSequence.whoIsTheWinner(Arrays.asList(1, 2, 2, 3));
        System.out.println("result = " + result);
    }

    public static String whoIsTheWinner(List<Integer> arr) {
        // WRITE DOWN YOUR CODE HERE
        Map<Integer, Integer> countMap = createMap(arr);

        boolean isUniqueArray = true;
        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            if (entry.getValue() > 1) {
                isUniqueArray = false;
                break;
            }
        }
        if (isUniqueArray) return FIRST;

        if (countMap.size() == 1) {
            for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
                int entryVal = entry.getValue();
                if (entryVal % 2 == 0) {
                    return SECOND;
                } else {
                    return FIRST;
                }
            }
        }

        int duplicateCount = 0;
        int uniqueCount = 0;

        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            if (entry.getValue() > 1) {
                duplicateCount += entry.getValue();
            } else {
                uniqueCount += entry.getValue();
            }
        }

        if (duplicateCount % 2 == 0 && uniqueCount % 2 == 0) {
            return SECOND;
        } else if (duplicateCount % 2 == 0) {
            return FIRST;
        } else if (uniqueCount % 2 != 0) {
            return SECOND;
        } else {
            return FIRST;
        }


    }

    private static Map<Integer, Integer> createMap(List<Integer> arr) {
        Map<Integer, Integer> map = new HashMap<>();

        for (Integer i : arr) {
            if (map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            } else {
                map.put(i, 1);
            }
        }

        return map;

    }


}
