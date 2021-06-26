package com.blind_list_75;

public class ValidPalindrome {

    //s = "A man, a plan, a canal: Panama"
    public static void main(String[] args) {

        ValidPalindrome validPalindrome = new ValidPalindrome();
        boolean result = validPalindrome.isPalindrome("race a car");
        System.out.println(result);
    }

    public boolean isPalindrome(String s) {

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (Character.isAlphabetic(c) || Character.isDigit(c)) {
                sb.append(Character.toLowerCase(c));
            }
        }

        return isValidPalindrome(sb.toString());


    }

    private boolean isValidPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left <= right) {
            char l = s.charAt(left);
            char r = s.charAt(right);
            if (l != r) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }
}
