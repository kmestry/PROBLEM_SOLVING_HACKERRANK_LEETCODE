package com.datastructure_studyplan_leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IntersectionOfTwoArrays {

    public int[] intersect(int[] nums1, int[] nums2) {

        List<Integer> list = new ArrayList<>();

        Map<Integer, Integer> map1 = new HashMap<>();
        Map<Integer, Integer> map2 = new HashMap<>();

        for (int i = 0; i < nums1.length; i++) {

            if (map1.containsKey(nums1[i])) {
                map1.put(nums1[i], map1.get(nums1[i]) + 1);
            } else {
                map1.put(nums1[i], 1);
            }
        }

        for (int i = 0; i < nums2.length; i++) {
            if (map2.containsKey(nums2[i])) {
                map2.put(nums2[i], map2.get(nums2[i]) + 1);
            } else {
                map2.put(nums2[i], 1);
            }
        }

        for (Map.Entry<Integer, Integer> entry : map1.entrySet()) {

            int key = entry.getKey();
            if (map2.containsKey(key)) {
                int count = map1.get(key) < map2.get(key) ? map1.get(key) : map2.get(key);

                for (int i = 0; i < count; i++) {
                    list.add(key);
                }
            }
        }

        //System.out.println(list);

        int[] result = new int[list.size()];

        int index = 0;
        for (Integer i : list) {
            result[index++] = i;
        }

        return result;
    }
}
