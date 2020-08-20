package com.leetcode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FirsUniqueCharacterInString {

    public int firstUniqChar(String s) {

        Map<Character, Integer> charMap = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (charMap.containsKey(c)) {
                charMap.put(c, charMap.get(c) + 1);
            } else {
                charMap.put(c, 1);
            }
        }

        //System.out.println(charMap);
        charMap.entrySet().stream().filter(characterIntegerEntry -> characterIntegerEntry.getValue() == 1);
        List<Map.Entry<Character, Integer>> listEntries = charMap.entrySet().stream().filter(charEntry -> charEntry.getValue() == 1).collect(Collectors.toList());

        //System.out.println(listEntries);

        if (listEntries.size() == 0) return -1;

        int minIndex = s.indexOf(listEntries.get(0).getKey());
        System.out.println(minIndex);

        for (Map.Entry<Character, Integer> entry : listEntries) {
            int index = s.indexOf(entry.getKey());
            if (index < minIndex) minIndex = index;
        }

        return minIndex;

    }
}
