package com.leetcode_restart;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IntersectionOfTwoArraysOptimized {

    public int @NotNull [] intersect(int @NotNull [] nums1, int @NotNull [] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> resultList = new ArrayList<>();

        for (int num : nums1) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }
        for (int num : nums2) {
            if (map.containsKey(num) && map.get(num) > 0) {
                resultList.add(num);
                map.put(num, map.get(num) - 1);
            }

        }
        //  System.out.println(map);
        // System.out.println(resultList);
        int[] result = new int[resultList.size()];

        int index = 0;
        for (Integer num : resultList) {
            result[index] = num;
            index++;
        }
        return result;


    }

}
