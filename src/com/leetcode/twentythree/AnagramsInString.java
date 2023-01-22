package com.leetcode.twentythree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AnagramsInString {

    private static void createMap(String p, Map<Character, Integer> pMap, int i) {
        char c = p.charAt(i);

        if (pMap.containsKey(c)) {
            pMap.put(c, pMap.get(c) + 1);
        } else {
            pMap.put(c, 1);
        }
    }

    public List<Integer> findAnagrams(String s, String p) {

        List<Integer> list = new ArrayList<>();
        if (p.length() > s.length()) return list;
        Map<Character, Integer> pMap = new HashMap<>();
        Map<Character, Integer> sMap = new HashMap<>();

        for (int i = 0; i < p.length(); i++) {

            createMap(p, pMap, i);
        }

        int start = 0;
        int end = p.length();
        //first substring
        for (int i = start; i < end; i++) {
            createMap(s, sMap, i);
        }

        if (pMap.equals(sMap)) list.add(start);

        while (end < s.length()) {

            char sStart = s.charAt(start);

            if (sMap.get(sStart) > 1) {
                sMap.put(sStart, sMap.get(sStart) - 1);
            } else {
                sMap.remove(sStart);
            }

            start++;
            createMap(s, sMap, end);
            end++;
            if (pMap.equals(sMap)) list.add(start);

        }

        return list;

    }
}
