package com.blind_list_75.string;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingCharacters longestSubstringWithoutRepeatingCharacters = new LongestSubstringWithoutRepeatingCharacters();
        longestSubstringWithoutRepeatingCharacters.lengthOfLongestSubstring("dvdf");
    }

    public int lengthOfLongestSubstring(String s) {


        int left = 0;
        int right = 0;

        int maxLength = 0;
        Set<Character> set = new HashSet<>();
        while (right < s.length()) {
            char c = s.charAt(right);

            if (!set.contains(c)) {
                set.add(c);
                right++;
                maxLength = Math.max(maxLength, set.size());
            } else {
                set.remove(s.charAt(left));
                left++;
            }
        }

        return maxLength;

    }
}
