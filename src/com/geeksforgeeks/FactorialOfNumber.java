package com.geeksforgeeks;

public class FactorialOfNumber {

    public static void main(String[] args) {
        int result = new FactorialOfNumber().factorialRecursive(5);
        System.out.println("result = " + result);
    }

    private int factorial(int number) {
        int result = 1;

        for (int i = 1; i <= number; i++) {
            result *= i;
        }

        return result;
    }

    private int factorialRecursive(int n) {

        if (n == 1) {
            return 1;
        }
        int val = n * factorialRecursive(n - 1);
        System.out.println("val = " + val);
        return val;
    }
}
