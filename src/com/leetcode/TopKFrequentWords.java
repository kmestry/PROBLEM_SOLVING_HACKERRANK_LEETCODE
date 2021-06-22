package com.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class TopKFrequentWords {

  /*  Input: ["i", "love", "leetcode", "i", "love", "coding"], k = 2
    Output: ["i", "love"]
    Explanation: "i" and "love" are the two most frequent words.
    Note that "i" comes before "love" due to a lower alphabetical order.*/

    public static void main(String[] args) {
        TopKFrequentWords topKFrequentWords = new TopKFrequentWords();
        List<String> resultList = topKFrequentWords.topKFrequent(new String[]{"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"},
                4);
        System.out.println(resultList);
    }

    public List<String> topKFrequent(String[] words, int k) {

        // i : 2, love : 2, leetcode: 1, coding: 1 : treemap
        //map word, count
        // list<count> desc. 2, 2 , 1, 1

        TreeMap<String, Integer> treeMap = new TreeMap<>();

        for (int i = 0; i < words.length; i++) {
            treeMap.merge(words[i], 1, Integer::sum);
        }
        List<Integer> list = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : treeMap.entrySet()) {
            list.add(entry.getValue());
        }
        list.sort((o1, o2) -> o2 - o1);

        List<String> result = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            int count = list.get(i);

            for (Map.Entry<String, Integer> entry : treeMap.entrySet()) {
                int wordCount = entry.getValue();
                if (count == wordCount) {
                    result.add(entry.getKey());
                    treeMap.remove(entry.getKey());
                    break;
                }
            }
        }
        return result;
    }
}
