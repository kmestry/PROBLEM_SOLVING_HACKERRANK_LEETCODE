package com.leetcode;

public class SplitAStringInBalancedString {

    public int balancedStringSplit(String s) {

        int rightPointer = 0;

        int RCount = 0;
        int LCount = 0;

        int result = 0;

        while (rightPointer < s.length()) {

            if (RCount != 0 && LCount != 0 && RCount == LCount) {
                result++;
                RCount = 0;
                LCount = 0;
            } else if (s.charAt(rightPointer) == 'R') {
                RCount++;
                rightPointer++;
            } else if (s.charAt(rightPointer) == 'L') {
                LCount++;
                rightPointer++;
            }

        }
        if (RCount != 0 && LCount != 0 && RCount == LCount) {
            result++;
        }

        return result;
    }
}
