package com.leetcode_restart;


import java.util.*;

public class IntersectionOfTwoArrays {

    public int[] intersect(int[] nums1, int[] nums2) {

        List<Integer> resultList = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        Map<Integer, Integer> map1 = new HashMap<>();
        Map<Integer, Integer> map2 = new HashMap<>();
        for (int value : nums1) {
            if (map1.containsKey(value)) {
                map1.put(value, map1.get(value) + 1);
            } else {
                map1.put(value, 1);
            }
            set.add(value);
        }


        for (int value : nums2) {
            if (map2.containsKey(value)) {
                map2.put(value, map2.get(value) + 1);
            } else {
                map2.put(value, 1);
            }
            set.add(value);
        }

        for (Integer i : set) {
            if (Objects.equals(map1.get(i), map2.get(i))) {

                for (int j = 0; j < map1.get(i); j++) {
                    resultList.add(i);
                }
            } else if (map1.containsKey(i) && map2.containsKey(i)) {
                int iteration = map1.get(i) < map2.get(i) ? map1.get(i) : map2.get(i);

                for (int k = 0; k < iteration; k++) {
                    resultList.add(i);
                }
            }
        }

        //System.out.println(resultList);

        int[] result = new int[resultList.size()];
        if (resultList.size() == 0) return result;

        int index = 0;
        for (Integer i : resultList) {
            result[index] = i;
            index++;
        }

        return result;
    }
}
