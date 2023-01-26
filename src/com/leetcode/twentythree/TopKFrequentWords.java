package com.leetcode.twentythree;

import java.util.*;

public class TopKFrequentWords {

    public static void main(String[] args) {
        TopKFrequentWords topKFrequentWords = new TopKFrequentWords();
        topKFrequentWords.topKFrequent(new String[]{"i", "love", "leetcode", "i", "love", "coding"}, 2);
    }

    public List<String> topKFrequent(String[] words, int k) {

        Map<String, Integer> map = new HashMap<>();
        List<String> result = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            String word = words[i];

            if (map.containsKey(word)) {
                map.put(word, map.get(word) + 1);
            } else {
                map.put(word, 1);
            }
        }
        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>(
                (a, b) -> Objects.equals(a.getValue(), b.getValue()) ? b.getKey().compareTo(a.getKey()) : a.getValue() - b.getValue()
        );

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            pq.offer(entry);
            if (pq.size() > k)
                pq.poll();
        }

        while (!pq.isEmpty())
            result.add(0, pq.poll().getKey());

        return result;
    }
}
