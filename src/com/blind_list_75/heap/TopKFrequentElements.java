package com.blind_list_75.heap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class TopKFrequentElements {

    public int[] topKFrequent(int[] nums, int k) {

        Map<Integer, Integer> map = new ConcurrentHashMap<>();

        for (int num : nums) {
            map.merge(num, 1, Integer::sum);
        }

        List<Integer> list = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int value = entry.getValue();
            list.add(value);
        }
        list.sort(Collections.reverseOrder());

        int[] result = new int[k];
        int index = 0;
        for (int i = 0; i < k; i++) {
            int element = list.get(i);
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                int value = entry.getValue();
                if (element == value) {
                    result[index] = entry.getKey();
                    index++;
                    map.remove(entry.getKey());
                    break;
                }
            }
        }
        return result;
    }
}
