package com.geeksforgeeks.strings;

public class CheckIfPalindromeString {

    public static void main(String[] args) {
        CheckIfPalindromeString checkIfPalindromeString = new CheckIfPalindromeString();
        boolean result = checkIfPalindromeString.isPalindrome("ABBa");
        System.out.println(result);
    }

    private boolean isPalindrome(String inputStr) {
        int left = 0;
        int right = inputStr.length() - 1;

        while (left <= right) {
            char leftVal = inputStr.charAt(left);
            char rightVal = inputStr.charAt(right);

            if (leftVal == rightVal) {
                left++;
                right--;
            } else if (Math.abs(rightVal - leftVal) == 32) {
                left++;
                right--;
            } else {
                return false;
            }

        }

        return true;
    }
}
