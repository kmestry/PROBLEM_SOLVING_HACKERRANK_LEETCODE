package com.leetcode;

public class LongestPalindromeSubstringJanChallenge {

    //TLE 0(N^2)  + O(N)
    public static void main(String[] args) {
        new LongestPalindromeSubstringJanChallenge().longestPalindrome("babad");
    }

    public String longestPalindrome(String s) {

        String result = s.charAt(0) + "";
        int length = s.length();
        for (int i = 0; i < length; i++) {
            StringBuilder check = new StringBuilder(s.charAt(i) + "");
            for (int j = i + 1; j < length; j++) {
                StringBuilder newCheck = check.append(s.charAt(j));
                if (newCheck.length() > result.length() && isPalindrome(String.valueOf(newCheck))) {
                    result = String.valueOf(newCheck);
                }
            }
        }

        return result;

    }

    private boolean isPalindrome(String check) {
        int start = 0;
        int end = check.length() - 1;

        while (start <= end) {
            if (check.charAt(start) == check.charAt(end)) {
                start++;
                end--;
            } else {
                return false;
            }
        }

        return true;
    }
}
