package com.leetcode_march_22;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SortCharactersByFrequency {
    public static void main(String[] args) {


        SortCharactersByFrequency sortCharactersByFrequency = new SortCharactersByFrequency();
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

        List<Map.Entry<Character, Integer>> list = new ArrayList<>(freqMap.entrySet());

        list.sort((o1, o2) -> o2.getValue() - o1.getValue());

       // System.out.println(list);

        StringBuilder result = new StringBuilder();
        for (Map.Entry<Character, Integer> entry : list) {
            int repeatedCount = entry.getValue();

            result.append(String.valueOf(entry.getKey()).repeat(Math.max(0, repeatedCount)));
        }

        //System.out.println(result);
        return result.toString();
    }
}
