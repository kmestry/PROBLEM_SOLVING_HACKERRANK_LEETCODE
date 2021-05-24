package com.geeksforgeeks.strings;

public class CheckIfStringIsSubsequence {
    public boolean isSubsequence(String s, String t) {

        return helper(s, t, s.length() - 1, t.length() - 1);

    }

    // recursive solution
    private boolean helper(String s, String t, int pointerS, int pointerT) {

        if (pointerS < 0) {
            return true;
        }

        if (pointerT < 0) {
            return false;
        }

        char sChar = s.charAt(pointerS);
        char tChar = t.charAt(pointerT);

        if (sChar == tChar) {
            return helper(s, t, pointerS - 1, pointerT - 1);
        } else {
            return helper(s, t, pointerS, pointerT - 1);
        }
    }
}
