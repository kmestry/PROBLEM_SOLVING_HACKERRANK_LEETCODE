package com.leetcode;

import java.util.HashMap;
import java.util.Map;

public class IsomorphicStrings {

    public boolean isIsomorphic(String s, String t) {

        if (s.equals(t)) return true;
        Map<Character, Integer> map1 = new HashMap<>();  // character - position/index map
        StringBuilder pattern1 = new StringBuilder();
        Map<Character, Integer> map2 = new HashMap<>();
        StringBuilder pattern2 = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {

            char c1 = s.charAt(i);


            if (map1.containsKey(c1)) {
                int position = map1.get(c1);
                pattern1.append(position);

            } else {
                map1.put(c1, i);
                pattern1.append(i);
            }
        }
        for (int i = 0; i < t.length(); i++) {
            char c2 = t.charAt(i);
            if (map2.containsKey(c2)) {
                int position = map2.get(c2);
                pattern2.append(position);

            } else {
                map2.put(c2, i);
                pattern2.append(i);
            }
        }

        return pattern1.toString().equals(pattern2.toString());

    }
}

