package com.leetcode_restart;

import java.util.HashMap;
import java.util.Map;

public class PermutationInString {

    public boolean checkInclusion(String s1, String s2) {

        Map<Character, Integer> s1Map = new HashMap<>();

        calculateFreq(s1, s1Map);

        int l = 0;
        int r = s1.length();

        while (r <= s2.length()) {

            String s = s2.substring(l, r);
            //System.out.println("== " + s);
            Map<Character, Integer> s2Map = new HashMap<>();
            calculateFreq(s, s2Map);
            if (s1Map.equals(s2Map)) {
                return true;
            }
            l++;
            r++;
        }
        return false;
    }

    private void calculateFreq(String s1, Map<Character, Integer> s1Map) {
        for (int i = 0; i < s1.length(); i++) {
            char c = s1.charAt(i);
            if (s1Map.containsKey(c)) {
                s1Map.put(c, s1Map.get(c) + 1);
            } else {
                s1Map.put(c, 1);
            }
        }
    }
}
