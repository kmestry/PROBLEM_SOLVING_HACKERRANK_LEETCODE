package com.leetcode_restart;

public class PermutationInStringOptimized {

    public boolean checkInclusion(String s1, String s2) {

        if (s1.length() > s2.length()) return false;
        char[] chars = new char[26];

        for (int i = 0; i < s1.length(); i++) {
            char c = s1.charAt(i);
            chars[c - 'a']++;
        }

        int l = 0;
        int r = s1.length() - 1;
        char[] charsS2 = new char[26];

        //first window till second last element of substring between l and r
        for (int i = l; i < r; i++) {
            char c = s2.charAt(i);
            charsS2[c - 'a']++;
        }

        while (r < s2.length()) {
            charsS2[s2.charAt(r) - 'a']++;
            if (compare(chars, charsS2)) {
                return true;
            } else {
                charsS2[s2.charAt(l) - 'a']--;
                l++;
                r++;
            }
        }

        return false;
    }

    private boolean compare(char[] c1, char[] c2) {

        for (int i = 0; i < 26; i++) {
            if (c1[i] != c2[i]) {
                return false;
            }
        }
        return true;
    }
}
