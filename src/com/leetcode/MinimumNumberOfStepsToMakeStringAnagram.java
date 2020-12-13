package com.leetcode;

public class MinimumNumberOfStepsToMakeStringAnagram {

    public static void main(String[] args) {
        new MinimumNumberOfStepsToMakeStringAnagram().minSteps("friend", "family");
    }

    public int minSteps(String s, String t) {
        int length = s.length();
        int[] array1 = new int[26];
        int[] array2 = new int[26];

        for (int i = 0; i < length; i++) {
            char ch = s.charAt(i);
            array1[ch - 'a']++;
        }

        for (int i = 0; i < length; i++) {
            char ch = t.charAt(i);
            array2[ch - 'a']++;
        }

        int result = 0;

        for (int i = 0; i < 26; i++) {
            int freqS = array1[i];
            int freqT = array2[i];


            result += Math.abs(freqT - freqS);

        }

        return result / 2;

    }
}
