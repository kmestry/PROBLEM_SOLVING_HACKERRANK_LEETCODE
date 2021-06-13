package com.geeksforgeeks.strings;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharactersEfficient {

    public int lengthOfLongestSubstring(String s) {

        int left = 0;
        int right = 0;
        int max = 0;
        Set<Character> set = new HashSet<>();
        while (right < s.length()) {
            char c = s.charAt(right);

            if (set.contains(c)) {
                max = Math.max(max, set.size());
                set.remove(s.charAt(left));
                left++;
            } else {
                set.add(c);
                right++;
            }
        }
        max = Math.max(max, set.size());

        return max;
    }
}
