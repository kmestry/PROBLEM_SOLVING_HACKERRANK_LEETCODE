package com.leetcode;

public class LongestSubstringWithAtleastKrepeatingCharactersPractise {

    public static void main(String[] args) {

        int res = new LongestSubstringWithAtleastKrepeatingCharactersPractise().longestSubstring("aaabbcddaeaaff", 2);
        //int res = new LongestSubstringWithAtleastKrepeatingCharactersPractise().longestSubstring("aaabb", 3);
        System.out.println("res = " + res);
    }


    public int longestSubstring(String s, int k) {

        return div(s, 0, s.length(), k);
    }

    private int div(String str, int start, int end, int k) {

        if (end - start < k) {
            return 0;
        }


        int[] freq = new int[26];
        for (int i = start; i < end; i++) {
            char c = str.charAt(i);
            freq[c - 'a']++;
        }

        for (int i = 0; i < freq.length; i++) {

            if (freq[i] > 0 && freq[i] < k) {

                for (int j = start; j < end; j++) {
                    char ch = str.charAt(j);
                    if (ch == i + 'a') {

                        int left = div(str, start, j, k);
                        int right = div(str, j + 1, end, k);
                        return Math.max(left, right);
                    }
                }

            }
        }

        return end - start;

    }
}
