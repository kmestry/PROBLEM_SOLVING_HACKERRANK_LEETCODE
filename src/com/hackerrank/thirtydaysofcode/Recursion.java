package com.hackerrank.thirtydaysofcode;

public class Recursion {

    // Multiply 'n' by 'k' using addition:
    private static int nTimesK(int n, int k) {
        System.out.println("n: " + n);
        // Recursive Case
        if (n > 1) {
            return k + nTimesK(n - 1, k);
        }
        // Base Case n = 1
        else {
            return k;
        }
    }

    public static void main(String[] args) {
        int result = nTimesK(4, 4);
        System.out.println("Result: " + result);
    }
}
