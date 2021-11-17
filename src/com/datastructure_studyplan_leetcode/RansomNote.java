package com.datastructure_studyplan_leetcode;

public class RansomNote {

    public boolean canConstruct(String ransomNote, String magazine) {

        int[] magaArr = new int[26];
        for (int i = 0; i < magazine.length(); i++) {
            char c = magazine.charAt(i);
            magaArr[c - 'a']++;
        }

        int[] noteArray = new int[26];
        for (int i = 0; i < ransomNote.length(); i++) {
            char c = ransomNote.charAt(i);
            noteArray[c - 'a']++;
        }

        for (int i = 0; i < ransomNote.length(); i++) {
            char c = ransomNote.charAt(i);

            if (noteArray[c - 'a'] <= magaArr[c - 'a'])
                continue;
            else
                return false;
        }
        return true;
    }
}
