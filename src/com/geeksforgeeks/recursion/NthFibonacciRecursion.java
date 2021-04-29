package com.geeksforgeeks.recursion;

public class NthFibonacciRecursion {
    static int fibonacci(int n) {
        // your code here
        if (n < 3) {
            return 1;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }
}
