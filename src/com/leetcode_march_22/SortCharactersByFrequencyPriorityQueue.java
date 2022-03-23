package com.leetcode_march_22;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class SortCharactersByFrequencyPriorityQueue {
    public static void main(String[] args) {


        SortCharactersByFrequencyPriorityQueue sortCharactersByFrequency = new SortCharactersByFrequencyPriorityQueue();
        sortCharactersByFrequency.frequencySort("tree");

    }


    //"tree"
    public String frequencySort(String s) {

        Map<Character, Integer> freqMap = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (freqMap.containsKey(c)) {
                freqMap.put(c, freqMap.get(c) + 1);
            } else {
                freqMap.put(c, 1);
            }
        }

        PriorityQueue<Map.Entry<Character, Integer>> priorityQueue = new PriorityQueue<>((o1, o2) -> o2.getValue() - o1.getValue());
        priorityQueue.addAll(freqMap.entrySet());

        StringBuilder result = new StringBuilder();
        while (!priorityQueue.isEmpty()) {
            Map.Entry<Character, Integer> entry = priorityQueue.poll();

            int repeatedTimes = entry.getValue();
            result.append(String.valueOf(entry.getKey()).repeat(Math.max(0, repeatedTimes)));
        }

       // System.out.println(result);
        return result.toString();

    }
}
