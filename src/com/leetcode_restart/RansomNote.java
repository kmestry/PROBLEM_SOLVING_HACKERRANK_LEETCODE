package com.leetcode_restart;


public class RansomNote {

    public boolean canConstruct(String ransomNote, String magazine) {

        int[] charRN = new int[26];

        for (int i = 0; i < ransomNote.length(); i++) {
            char c = ransomNote.charAt(i);
            charRN[c - 'a']++;
        }

        int[] charMZ = new int[26];

        for (int i = 0; i < magazine.length(); i++) {
            char c = magazine.charAt(i);
            charMZ[c - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            if (charRN[i] > charMZ[i]) {
                return false;
            }
        }
        return true;
    }
}
