package com.geeksforgeeks.strings;

import java.util.HashMap;
import java.util.Map;

public class MinimumIndexedCharacter {

    public static int minIndexChar(String str, String patt) {
        // Your code here
        Map<Character, Integer> charIndexMap = new HashMap<>();

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            if (!charIndexMap.containsKey(c)) {
                charIndexMap.put(c, i);
            }
        }

        int minIndex = Integer.MAX_VALUE;

        for (int i = 0; i < patt.length(); i++) {
            char c = patt.charAt(i);

            if (charIndexMap.containsKey(c)) {
                minIndex = Math.min(minIndex, charIndexMap.get(c));
            }
        }

        return minIndex;
    }
}
