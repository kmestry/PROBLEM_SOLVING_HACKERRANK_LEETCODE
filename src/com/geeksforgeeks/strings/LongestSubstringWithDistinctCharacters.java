package com.geeksforgeeks.strings;

public class LongestSubstringWithDistinctCharacters {
    public static void main(String[] args) {
        LongestSubstringWithDistinctCharacters longestSubstringWithDistinctCharacters = new LongestSubstringWithDistinctCharacters();
        int result = longestSubstringWithDistinctCharacters.longestSubstringWithDistinctCharacters("qwerty");
        System.out.println(result);
    }

    private int longestSubstringWithDistinctCharacters(String s1) {

        int longestSubstringWithDistinctChars = 1;
        for (int i = 0; i < s1.length(); i++) {
            char[] chars = new char[128];
            int pointer = i;
            int count = 0;
            while (pointer < s1.length()) {
                if (chars[s1.charAt(pointer)] >= 1) {
                    longestSubstringWithDistinctChars = Math.max(count, longestSubstringWithDistinctChars);
                    break;
                } else {
                    chars[s1.charAt(pointer)]++;
                }
                pointer++;
                count++;
            }

            longestSubstringWithDistinctChars = Math.max(count, longestSubstringWithDistinctChars);
        }

        return longestSubstringWithDistinctChars;
    }
}
