package com.leetcode;

import java.util.HashMap;
import java.util.Map;

public class IsValidAnagram {


    public boolean isAnagram(String s, String t) {

        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < t.length(); i++) {

            char c = t.charAt(i);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }


        for (int j = 0; j < s.length(); j++) {
            char sChar = s.charAt(j);

            if (map.containsKey(sChar) && map.get(sChar) > 0) {

                map.put(sChar, map.get(sChar) - 1);
                if (map.get(sChar) == 0) map.remove(sChar);

            } else {
                return false;
            }
        }


        return map.isEmpty();
    }
}
