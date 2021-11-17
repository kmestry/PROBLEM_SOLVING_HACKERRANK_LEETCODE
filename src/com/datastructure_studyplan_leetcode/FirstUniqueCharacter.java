package com.datastructure_studyplan_leetcode;

public class FirstUniqueCharacter {

    public int firstUniqChar(String s) {

        int[] countArray = new int[26];

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            countArray[c - 'a']++;

        }

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int count = countArray[c - 'a'];
            if (count == 1) {
                return i;
            }
        }
        return -1;
    }
}
