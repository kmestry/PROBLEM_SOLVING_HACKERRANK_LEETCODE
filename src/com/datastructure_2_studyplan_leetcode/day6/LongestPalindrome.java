package com.datastructure_2_studyplan_leetcode.day6;

import java.util.HashMap;
import java.util.Map;

public class LongestPalindrome {

    public int longestPalindrome(String s) {

        int result = 0;
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }

        if (map.size() == 1) return map.get(s.charAt(0));

        boolean isOddCounted = false;
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {

            if (isOddCounted && entry.getValue() % 2 == 1) {
                result += entry.getValue() - 1;
            } else if (entry.getValue() % 2 == 0) {
                result += entry.getValue();
            } else {
                result += entry.getValue();
                isOddCounted = true;
            }
        }

        return result;

    }
}
