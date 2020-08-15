package com.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestPalindrome {

    public static void main(String[] args) {

        new LongestPalindrome().longestPalindrome("ccd");

    }

    //"abccccdd"
    public int longestPalindrome(String s) {

        Map<Character, Integer> characterCounterMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (characterCounterMap.get(s.charAt(i)) != null) {
                characterCounterMap.put(s.charAt(i), characterCounterMap.get(s.charAt(i)) + 1);
            } else {
                characterCounterMap.put(s.charAt(i), 1);
            }
        }

        boolean hasOddOccurrenceOfCount = false;
        int maxPalindromeLength = 0;
        for (Integer count : characterCounterMap.values()) {
            if (count % 2 == 0) {
                maxPalindromeLength += count;
            } else {
                hasOddOccurrenceOfCount = true;
                maxPalindromeLength += count - 1;
            }
        }

        return hasOddOccurrenceOfCount ? (maxPalindromeLength + 1) : maxPalindromeLength;


        //java 8 stream approach!
       /* final int[] maxPalindromeLength = {0};
        AtomicBoolean hasOddOccurrenceOfCharacter = new AtomicBoolean(false);
        characterCounterMap.entrySet().stream().forEach(characterIntegerEntry -> {
            final Integer countOfChar = characterIntegerEntry.getValue();
            if (countOfChar % 2 == 0) {
                maxPalindromeLength[0] += countOfChar;
            } else {
                int evenCount = countOfChar / 2;
                int evenPartOfOddCharCount = 2 * evenCount;
                maxPalindromeLength[0] += evenPartOfOddCharCount;
                hasOddOccurrenceOfCharacter.set(true);
            }
        });

        return hasOddOccurrenceOfCharacter.get() ? maxPalindromeLength[0] + 1 : maxPalindromeLength[0];*/
    }

    public int longestPalindromeSetApproach(String s) {
        Set<Character> characterSet = new HashSet<>();
        int maxPalindromeLength = 0;
        for (int i = 0; i < s.length(); i++) {
            if (characterSet.contains(s.charAt(i))) {
                characterSet.remove(s.charAt(i));
                maxPalindromeLength += 2;
            } else {
                characterSet.add(s.charAt(i));
            }
        }

        return characterSet.size() > 0 ? maxPalindromeLength + 1 : maxPalindromeLength;
    }
}
