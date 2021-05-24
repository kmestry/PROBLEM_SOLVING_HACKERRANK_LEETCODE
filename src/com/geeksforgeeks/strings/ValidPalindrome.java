package com.geeksforgeeks.strings;

public class ValidPalindrome {

    public static void main(String[] args) {
        ValidPalindrome validPalindrome = new ValidPalindrome();
        //boolean result = validPalindrome.isPalindrome("A man, a plan, a canal: Panama");
        boolean result = validPalindrome.isPalindrome("0P");
        System.out.println(result);
        System.out.println((char) 65);
    }

    public boolean isPalindrome(String s) {

        int left = 0;
        int right = s.length() - 1;

        while (left <= right) {
            char l = s.charAt(left);
            char r = s.charAt(right);

            if (!isAlphanumeric(l)) {
                left++;
            } else if (!isAlphanumeric(r)) {
                right--;
            } else if (l == r) {
                left++;
                right--;
            } else if (l > 57 && r > 57 && Math.abs(l - r) == 32) { // logic to check upper and lower case.
                //diff is always 32 between upper and lower case alphabets. but compare only alphabets.
                //hence the additional check for l and r > 57 to handle corner case "0P" 80 - 48 = 32
                left++;
                right--;
            } else {
                return false;
            }
        }

        return true;
    }

    private boolean isAlphanumeric(char l) {
        return (l > 47 && l < 58) || (l >= 65 && l <= 90) || (l >= 97 && l <= 122);
    }
}
