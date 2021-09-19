package com.geeksforgeeks.hashing;

import java.util.HashMap;
import java.util.Map;

public class CheckIfTwoArraysAreEqual {

    public static boolean check(long[] A, long[] B, int N) {
        Map<Long, Integer> map = new HashMap<>();

        for (long element : A) {
            map.merge(element, 1, Integer::sum);
        }

        for (long element : B) {
            if (map.containsKey(element)) {
                map.put(element, map.get(element) - 1);
                if (map.get(element) == 0) {
                    map.remove(element);
                }
            }
        }

        return map.size() == 0;
    }
}
