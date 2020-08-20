package com.leetcode;

public class LongestPalindromicSubstring {

    public String longestPalindrome(String s) {
        String resultString = "";
        for (int i = 0; i < s.length(); i++) {
            String checkString = "";
            for (int j = i; j < s.length(); j++) {
                checkString += s.charAt(j);
                //System.out.println(checkString);
                boolean flag = isPalindrome(checkString);
                if (flag) {
                    if (checkString.length() > resultString.length()) {
                        resultString = checkString;
                    }
                }
            }
        }

        return resultString;

    }

    private boolean isPalindrome(String inputString) {

        int leftPointer = 0;
        int rightPointer = inputString.length() - 1;

        while (leftPointer <= rightPointer) {
            if (inputString.charAt(leftPointer) == inputString.charAt(rightPointer)) {
                leftPointer++;
                rightPointer--;
            } else {
                return false;
            }

        }

        return true;


    }
}
