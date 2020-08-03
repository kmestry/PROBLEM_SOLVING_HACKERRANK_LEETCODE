package com.leetcode;


public class ValidPalindrome {
    public static void main(String[] args) {

        boolean result = new ValidPalindrome().isPalindrome("A man, a plan, a canal: Panama");
        System.out.println("result = " + result);
    }

    public boolean isPalindrome(String s) {
        int startPointer = 0;
        int endPointer = s.length() - 1;


        //"A man, a plan, a canal: Panama"
        while (startPointer < endPointer) {
            int startChar = s.charAt(startPointer);
            int endChar = s.charAt(endPointer);

            final boolean endCharCondition = Character.isAlphabetic(endChar) || Character.isDigit(endChar);
            final boolean startCharCondition = Character.isAlphabetic(startChar) || Character.isDigit(startChar);
            if (startCharCondition && endCharCondition) {

                if (Character.toLowerCase(startChar) == Character.toLowerCase(endChar)) {
                    startPointer++;
                    endPointer--;
                } else {
                    return false;
                }
            } else if (!startCharCondition) {
                startPointer++;

            } else {
                endPointer--;
            }

        }
        return true;
    }
}
