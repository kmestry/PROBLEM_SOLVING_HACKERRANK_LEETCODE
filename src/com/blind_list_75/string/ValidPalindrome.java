package com.blind_list_75.string;

public class ValidPalindrome {

    public static void main(String[] args) {
        ValidPalindrome validPalindrome = new ValidPalindrome();
        validPalindrome.isPalindrome("A man, a plan, a canal: Panama");
    }

    public boolean isPalindrome(String s) {
        char[] chars = s.toCharArray();

        int left = 0;
        int right = chars.length - 1;

        while (left < right) {

            char l = s.charAt(left);
            char r = s.charAt(right);

            final boolean isLeftCharSpecialCharacter = !(Character.isAlphabetic(l) || Character.isDigit(l));
            final boolean isRightCharSpecialCharacter = !(Character.isAlphabetic(r) || Character.isDigit(r));

            if (isLeftCharSpecialCharacter || isRightCharSpecialCharacter) {
                if (isLeftCharSpecialCharacter) {
                    left++;
                }
                if (isRightCharSpecialCharacter) {
                    right--;
                }
            } else {

                if (Character.toLowerCase(l) != Character.toLowerCase(r)) {
                    return false;
                } else {
                    left++;
                    right--;
                }
            }
        }

        return true;
    }
}
