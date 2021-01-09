package com.leetcode;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharactersJanChallenge {

    public static void main(String[] args) {
        new LongestSubstringWithoutRepeatingCharactersJanChallenge().lengthOfLongestSubstring("ohvhjdml");
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
                set.add(c);
            } else {
                set.add(c);
            }

            right++;
        }

        maxLength = Math.max(maxLength, right - left);
        return maxLength;
    }
}
