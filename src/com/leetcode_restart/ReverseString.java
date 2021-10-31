package com.leetcode_restart;

public class ReverseString {

    public void reverseString(char[] s) {

        int l = 0;
        int r = s.length - 1;

        while (l < r) {

            char lC = s[l];
            char rC = s[r];

            s[l] = rC;
            s[r] = lC;

            l++;
            r--;

        }

    }
}
