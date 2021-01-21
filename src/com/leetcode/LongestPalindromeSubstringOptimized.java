package com.leetcode;

public class LongestPalindromeSubstringOptimized {

    public static void main(String[] args) {
        new LongestPalindromeSubstringOptimized().longestPalindrome("cbbd");

    }

    public String longestPalindrome(String s) {

        if (s.length() <= 1) return s;

        String result = "";
        for (int i = 0; i < s.length(); i++) {

            String odd = expandRange(s, i, i);

            if (odd.length() > result.length()) {
                result = odd;
            }

            String even = expandRange(s, i, i + 1);

            if (even.length() > result.length()) {
                result = even;
            }
        }

        return result;
    }


    private String expandRange(String s, int left, int right) {

        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return s.substring(left + 1, right); //left + 1 because after 0 the left will be -1 and the substring method begin index is inclusive.
        // we need not do to right + 1 because right will point  to s.length when it reaches end of string and the substring method end index is exclusive.

    }


}
