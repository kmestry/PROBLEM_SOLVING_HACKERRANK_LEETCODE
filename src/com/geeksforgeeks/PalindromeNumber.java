package com.geeksforgeeks;

public class PalindromeNumber {

    public static void main(String[] args) {
        boolean res = new PalindromeNumber().isPalindromeOptimized(Integer.MAX_VALUE);
        System.out.println("res = " + res);
    }

    private boolean isPalindromeOptimized(int number) {

        int rev = 0;
        int origNum = number;
        while (number != 0) {

            rev = rev * 10 + number % 10;
            number /= 10;
        }

        System.out.println("rev = " + rev);
        return rev == origNum;

    }

    private boolean isPalindrome(int number) {

        int origNumber = number;
        int power = (int) Math.floor(Math.log10(number) + 1) - 1;
        int reverseNum = 0;
        while (number > 0) {
            int remainder = number % 10;
            number /= 10;
            reverseNum += Math.pow(10, power) * remainder;
            power--;
        }
        return origNumber == reverseNum;
    }
}
