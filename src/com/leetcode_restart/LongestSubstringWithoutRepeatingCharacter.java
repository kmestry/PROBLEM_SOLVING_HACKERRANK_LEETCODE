package com.leetcode_restart;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacter {

    public int lengthOfLongestSubstring(String s) {

        int result = 0;
        Set<Character> set = new HashSet<>();

        int l = 0;
        int r = 0;

        while (r < s.length()) {

            char c = s.charAt(r);

            if (!set.contains(c)) {
                set.add(c);
                r++;
            } else {
                result = Math.max(result, r - l);
                set.remove(s.charAt(l));
                l++;
            }

        }

        return Math.max(result, r - l);

    }
}
