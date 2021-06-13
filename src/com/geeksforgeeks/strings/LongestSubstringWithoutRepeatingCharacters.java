package com.geeksforgeeks.strings;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingCharacters ls = new LongestSubstringWithoutRepeatingCharacters();
        ls.lengthOfLongestSubstring("pwwkew");
    }

    public int lengthOfLongestSubstring(String s) {
        int maxLength = Integer.MIN_VALUE;

        int left = 0;
        int right = 0;
        Set<Character> set = new HashSet<>();

        while (right < s.length()) {
            char c = s.charAt(right);

            if (set.contains(c)) {
                maxLength = Math.max(maxLength, right - left);
                set.remove(s.charAt(left));
                left++;
                while (set.contains(c) && left != right) {
                    set.remove(s.charAt(left));
                    left++;
                }
            }
            set.add(c);
            right++;
        }

        maxLength = Math.max(maxLength, right - left);
        return maxLength;
    }
}
