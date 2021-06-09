package com.geeksforgeeks.strings;

public class AnagramSearch {

    public static void main(String[] args) {

        AnagramSearch anagramSearch = new AnagramSearch();
        int count = anagramSearch.isAnagramPresent("aaba", "aabaabaa");
        System.out.println(count);
    }

    //naive approach TLE on GFG
    private int isAnagramPresent(String pattern, String text) {
        //geeksforgeeks
        //frog

        int patternLength = pattern.length();

        int pointer1 = 0;
        int pointer2 = patternLength;

        int count = 0;
        while (pointer2 <= text.length()) {
            String innerString = text.substring(pointer1, pointer2);
            if (isAnagram(innerString, pattern)) {
                count++;
            }
            pointer1++;
            pointer2++;
        }
        return count;

    }

    private boolean isAnagram(String s1, String s2) {

        char[] chars = new char[128];
        for (int i = 0; i < s1.length(); i++) {
            chars[s1.charAt(i)]++;
        }
        for (int i = 0; i < s2.length(); i++) {
            chars[s2.charAt(i)]--;
        }
        for (char aChar : chars) {
            if (aChar != 0) {
                return false;
            }
        }
        return true;
    }

}
