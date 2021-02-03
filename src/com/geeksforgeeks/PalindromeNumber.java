package com.geeksforgeeks;

public class PalindromeNumber {

    public static void main(String[] args) {
        boolean res = new PalindromeNumber().isPalindrome(431134);
        System.out.println("res = " + res);
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
