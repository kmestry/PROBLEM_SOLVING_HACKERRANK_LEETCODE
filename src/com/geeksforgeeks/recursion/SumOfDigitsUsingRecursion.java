package com.geeksforgeeks.recursion;

public class SumOfDigitsUsingRecursion {

    public static void main(String[] args) {

        SumOfDigitsUsingRecursion sumOfDigitsUsingRecursion = new SumOfDigitsUsingRecursion();
        int result = sumOfDigitsUsingRecursion.sumOfDigits(253);
        System.out.println("result = " + result);
    }

    // 253
    private int sumOfDigits(int number) {

        if (number == 0) {
            return 0;
        }

        return number % 10 + sumOfDigits(number / 10);
    }
}
