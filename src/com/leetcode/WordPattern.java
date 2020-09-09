package com.leetcode;

import java.util.HashMap;
import java.util.Map;

public class WordPattern {

    public boolean wordPattern(String pattern, String str) {

        Map<Character, String> map = new HashMap<>();

        String[] inputArray = str.split(" ");
        int pointer = 0;
        if (pattern.length() != inputArray.length) {
            return false;
        }

        int i = 0;
        while (i < pattern.length()) {

            char c = pattern.charAt(i);
            String inputString = inputArray[pointer];


            if (map.containsKey(c)) {
                String storedString = map.get(c);
                if (!storedString.equals(inputString)) return false;
            } else if (map.containsValue(inputString)) {
                if (evaluateString(map, c, inputString)) return false;
            } else {
                map.put(c, inputString);
            }
            pointer++;
            i++;
        }

        return true;

    }

    private boolean evaluateString(Map<Character, String> map, char c, String inputString) {
        for (Map.Entry<Character, String> entry : map.entrySet()) {
            if (inputString.equals(entry.getValue()) && entry.getKey() != c) return true;
        }
        return false;
    }
}
