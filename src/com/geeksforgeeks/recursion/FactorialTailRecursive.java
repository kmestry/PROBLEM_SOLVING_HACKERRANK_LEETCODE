package com.geeksforgeeks.recursion;

public class FactorialTailRecursive {
    public static void main(String[] args) {

        FactorialTailRecursive factorialTailRecursive = new FactorialTailRecursive();
        int result = factorialTailRecursive.factorial(5, 1);
        System.out.println("result = " + result);
    }

    //correct solution
    private int factorial(int number, int result) {

        if (number == 0) return result;

        return factorial(number - 1, result * number);

    }
}
