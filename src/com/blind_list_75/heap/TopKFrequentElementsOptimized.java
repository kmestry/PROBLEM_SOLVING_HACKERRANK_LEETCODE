package com.blind_list_75.heap;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;

public class TopKFrequentElementsOptimized {
    public static void main(String[] args) {
        TopKFrequentElementsOptimized topKFrequentElementsOptimized = new TopKFrequentElementsOptimized();
        topKFrequentElementsOptimized.topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2);
    }


    //[1,1,1,2,2,3], k = 2
    // 1 -> 3 , 2 -> 2, 3 -> 1
    public int[] topKFrequent(int[] nums, int k) {

        Map<Integer, Integer> freqMap = new HashMap<>();

        for (int num : nums) {
            freqMap.merge(num, 1, Integer::sum);
        }

        PriorityQueue<Entry<Integer, Integer>> pq = new PriorityQueue<>
                (Comparator.comparing(integerIntegerEntry -> integerIntegerEntry.getValue(), Comparator.reverseOrder()));
        pq.addAll(freqMap.entrySet());

        int[] result = new int[k];
        int index = 0;
        while (k > 0 && !pq.isEmpty()) {
            Entry<Integer, Integer> entry = pq.poll();
            result[index++] = entry.getKey();
            k--;
        }
        //  System.out.println(pq);

        return result;


    }
}
