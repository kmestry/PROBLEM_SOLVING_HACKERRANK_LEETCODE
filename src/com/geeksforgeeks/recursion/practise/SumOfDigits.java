package com.geeksforgeeks.recursion.practise;

public class SumOfDigits {


    public static void main(String[] args) {

        int result = SumOfDigits.sumOfDigits(232);
        System.out.println("result = " + result);

    }

    public static int sumOfDigits(int n) {
        if (n == 0) {
            return 0;
        }

        int result = sumOfDigits(n / 10);
        result += n % 10;
        return result;

    }
}
