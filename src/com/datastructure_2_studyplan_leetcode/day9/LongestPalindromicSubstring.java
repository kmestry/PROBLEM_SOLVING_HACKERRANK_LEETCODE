package com.datastructure_2_studyplan_leetcode.day9;

public class LongestPalindromicSubstring {

    public String longestPalindrome(String s) {

        int length = 1;
        String result = "";
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            String currStr = "";
            currStr += c;

            for (int j = i + 1; j < s.length(); j++) {
                currStr += s.charAt(j);
                if (isPalindrome(currStr)) {
                    if (currStr.length() > length) {
                        length = currStr.length();
                        result = currStr;
                    }

                }
            }
        }

        return result.length() == 0 ? result + s.charAt(0) : result;
    }


    private boolean isPalindrome(String str) {
        char[] chArr = str.toCharArray();

        int l = 0;
        int r = chArr.length - 1;

        while (l <= r) {
            if (str.charAt(l) != str.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}
