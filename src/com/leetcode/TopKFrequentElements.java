package com.leetcode;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class TopKFrequentElements {

    public static void main(String[] args) {

        topKFrequentOptimized(new int[]{1, 1, 1, 2, 2, 3}, 2);
    }

    public static int[] topKFrequentOptimized(int[] nums, int k) {

        Map<Integer, Integer> integerIntegerMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {

            if (integerIntegerMap.containsKey(nums[i])) {
                integerIntegerMap.put(nums[i], integerIntegerMap.get(nums[i]) + 1);
            } else {
                integerIntegerMap.put(nums[i], 1);
            }
        }

        PriorityQueue<Map.Entry<Integer, Integer>> priorityQueue = new PriorityQueue<>((o1, o2) -> o2.getValue() - o1.getValue());
        priorityQueue.addAll(integerIntegerMap.entrySet());

        int counter = 0;
        int[] result = new int[k];
        while (!priorityQueue.isEmpty() && counter < k) {
            result[counter] = priorityQueue.poll().getKey();
            counter++;
        }


        return result;
    }

    //  [1,1,1,2,2,3], k = 2
    public int[] topKFrequent(int[] nums, int k) {

        Map<Integer, Integer> integerIntegerMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {

            if (integerIntegerMap.containsKey(nums[i])) {
                integerIntegerMap.put(nums[i], integerIntegerMap.get(nums[i]) + 1);
            } else {
                integerIntegerMap.put(nums[i], 1);
            }
        }

        Map<Integer, Integer> sortedByValueDesc = integerIntegerMap.entrySet().stream().sorted(Map.Entry.<Integer, Integer>comparingByValue().reversed())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

        List<Integer> result = sortedByValueDesc.keySet().stream().limit(k).collect(Collectors.toList());

        return result.stream().mapToInt(Integer::intValue).toArray();
    }


}
