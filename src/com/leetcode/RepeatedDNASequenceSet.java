package com.leetcode;

import java.util.*;

public class RepeatedDNASequenceSet {

    public List<String> findRepeatedDnaSequences(String s) {

        if (s.length() < 10) return new ArrayList<>();

        Map<String, Integer> frequencyMap = new HashMap<>();

        int left = 0;
        int subStringRight = 10;


        Set<String> result = new HashSet<>();
        while (subStringRight <= s.length()) {

            String subString = s.substring(left, subStringRight);
            // System.out.println("=="+subString);
            if (frequencyMap.containsKey(subString)) {
                result.add(subString);
            } else {
                frequencyMap.put(subString, 1);
            }
            left++;
            subStringRight++;
        }


        return new ArrayList<>(result);
    }
}
