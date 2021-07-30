package com.blind_list_75.string;

public class ValidPalindromeOnePass {

    //s = "A man, a plan, a canal: Panama"
    public boolean isPalindrome(String s) {

        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            char l = s.charAt(left);
            char r = s.charAt(right);
            boolean isLeftValidChar = Character.isDigit(l) || Character.isAlphabetic(l);
            boolean isRightValidChar = Character.isDigit(r) || Character.isAlphabetic(r);

            if (isLeftValidChar && isRightValidChar) {
                if (Character.toLowerCase(l) == Character.toLowerCase(r)) {
                    left++;
                    right--;
                } else {
                    return false;
                }
            } else if (!isLeftValidChar) {
                left++;
            } else {
                right--;
            }
        }

        return true;
    }
}
