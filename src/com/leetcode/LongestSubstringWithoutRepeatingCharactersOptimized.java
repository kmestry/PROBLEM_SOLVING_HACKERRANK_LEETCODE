package com.leetcode;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharactersOptimized {


    public static void main(String[] args) {

        int result = new LongestSubstringWithoutRepeatingCharactersOptimized().lengthOfLongestSubstring("pwwkew");
        System.out.println("result = " + result);
    }

    //pwwkew
    public int lengthOfLongestSubstring(String s) {

        int startPointer = 0;
        int endPointer = 0;
        int maxCount = 0;

        Set<Character> characters = new HashSet<>();

        while (endPointer < s.length()) {
            Character charValueAtEndPointer = s.charAt(endPointer);
            if (!characters.contains(charValueAtEndPointer)) {
                characters.add(charValueAtEndPointer);
                endPointer++;
                maxCount = Math.max(maxCount, endPointer - startPointer);
            } else {
                Character charValueAtStartPointer = s.charAt(startPointer);
                characters.remove(charValueAtStartPointer);
                startPointer++;
            }
        }

        return maxCount;

    }
}
