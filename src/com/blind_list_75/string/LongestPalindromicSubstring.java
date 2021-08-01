package com.blind_list_75.string;

public class LongestPalindromicSubstring {

    public String longestPalindrome(String s) {

        if (s.length() < 2) return s;
        String result = "";
        for (int i = 0; i < s.length(); i++) {

            String even = expandRange(s, i, i + 1);
            String odd = expandRange(s, i, i);

            if (even.length() > result.length()) {
                result = even;
            }
            if (odd.length() > result.length()) {
                result = odd;
            }
        }

        return result;

    }

    private String expandRange(String s, int left, int right) {

        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }

        return s.substring(left + 1, right);

    }
}
