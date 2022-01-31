package com.datastructure_2_studyplan_leetcode.day20;

import java.util.*;

public class TopKFrequentElements {

    public int[] topKFrequent(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int val = nums[i];

            if (map.containsKey(val)) {
                map.put(val, map.get(val) + 1);
            } else {
                map.put(val, 1);
            }
        }

        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());

        list.sort((o1, o2) -> o2.getValue() - o1.getValue());

        int[] result = new int[k];
        int index = 0;

        for (Map.Entry<Integer, Integer> entry : list) {
            if (index >= k) break;
            result[index] = entry.getKey();
            index++;
        }

        return result;
    }
}
