package com.geeksforgeeks.recursion;

public class CheckIfStringIsPalindrome {
    public static void main(String[] args) {


        CheckIfStringIsPalindrome checkIfStringIsPalindrome = new CheckIfStringIsPalindrome();
        boolean result = checkIfStringIsPalindrome.isPalindrome("abbaa", 0, 4);
        System.out.println("result = " + result);
    }

    private boolean isPalindrome(String input, int left, int right) {

        if (left >= right) {
            return true;
        }

        if (input.charAt(left) == input.charAt(right)) {
            return isPalindrome(input, left + 1, right - 1);
        } else {
            return false;
        }
    }
}
