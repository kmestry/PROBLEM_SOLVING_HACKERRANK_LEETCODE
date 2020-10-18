package com.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RepeatedDNASequences {

    public List<String> findRepeatedDnaSequences(String s) {

        if (s.length() < 10) return new ArrayList<>();

        Map<String, Integer> frequencyMap = new HashMap<>();

        int left = 0;
        int subStringRight = 10;


        while (subStringRight <= s.length()) {

            String subString = s.substring(left, subStringRight);
            // System.out.println("=="+subString);
            if (frequencyMap.containsKey(subString)) {
                frequencyMap.put(subString, frequencyMap.get(subString) + 1);
            } else {
                frequencyMap.put(subString, 1);
            }
            left++;
            subStringRight++;
        }

        List<String> result = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : frequencyMap.entrySet()) {
            if (entry.getValue() > 1) {
                result.add(entry.getKey());
            }
        }

        return result;
    }
}
