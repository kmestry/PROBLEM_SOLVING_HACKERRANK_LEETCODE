package com.neetcode.io;

public class ValidPalindrome {

    public boolean isPalindrome(String s) {

        int l = 0;
        int r = s.length() - 1;

        while (l < r) {
            char left = s.charAt(l);
            char right = s.charAt(r);

            if (Character.isLetterOrDigit(left) && Character.isLetterOrDigit(right)) {
                if (Character.toLowerCase(left) != Character.toLowerCase(right))
                    return false;
                else {
                    l++;
                    r--;
                }

            } else if (!Character.isLetterOrDigit(left)) {
                l++;
            } else if (!Character.isLetterOrDigit(right)) {
                r--;
            }

        }

        return true;
    }
}
