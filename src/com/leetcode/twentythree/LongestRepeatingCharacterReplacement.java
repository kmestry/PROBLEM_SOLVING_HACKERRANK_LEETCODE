package com.leetcode.twentythree;

public class LongestRepeatingCharacterReplacement {

    public static void main(String[] args) {
        LongestRepeatingCharacterReplacement longestRepeatingCharacterReplacement = new LongestRepeatingCharacterReplacement();
        longestRepeatingCharacterReplacement.characterReplacement("AABABBA", 1);
    }

    public int characterReplacement(String s, int k) {

        int st = 0;
        int e = 0;

        int res = Integer.MIN_VALUE;

        int[] freq = new int[26];

        while (e < s.length()) {

            char c = s.charAt(e);
            freq[c - 'A']++;

            int replaced = e - st + 1 - topFreq(freq);
            if (replaced <= k) {
                res = Math.max(res, e - st + 1);
                e++;

            } else {
                freq[s.charAt(st) - 'A']--;
                st++;
                e++;

            }

        }
        return res;
    }

    private int topFreq(int[] freq) {
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < freq.length; i++) {
            max = Math.max(max, freq[i]);
        }

        return max;
    }

}
