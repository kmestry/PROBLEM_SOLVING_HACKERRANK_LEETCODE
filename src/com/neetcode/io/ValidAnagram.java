package com.neetcode.io;

public class ValidAnagram {


    public boolean isAnagram(String s, String t) {

        int[] sArr = new int[26];
        int[] tArr = new int[26];

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            sArr[c - 'a']++;
        }

        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            tArr[c - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            if (sArr[i] != tArr[i]) {
                return false;
            }
        }

        return true;
    }

}
