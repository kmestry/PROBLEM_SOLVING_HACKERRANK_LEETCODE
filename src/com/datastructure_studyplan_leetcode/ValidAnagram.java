package com.datastructure_studyplan_leetcode;

public class ValidAnagram {

    public boolean isAnagram(String s, String t) {

        int[] countArray = new int[26];

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            countArray[c - 'a']++;
        }

        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            countArray[c - 'a']--;
        }
        for (int i : countArray) {
            if (i != 0) {
                return false;
            }
        }

        return true;
    }
}
