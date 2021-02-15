package com.geeksforgeeks;

public class SpaceComplexityFibonacci {

    public static void main(String[] args) {

        int result = new SpaceComplexityFibonacci().fibonacci(10);
        System.out.println("result = " + result);
    }

    public int fibonacci(int n) {


        if (n == 0 || n == 1) {
            return n;
        }

        int a = fibonacci(n - 1);
        int b = fibonacci(n - 2);
        return a + b;
    }
}
