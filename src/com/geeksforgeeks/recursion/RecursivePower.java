package com.geeksforgeeks.recursion;

public class RecursivePower {

    static int RecursivePower(int n, int p) {
        // add your code here
        if (p == 0) {
            return 1;
        }
        return RecursivePower(n, p - 1) * n;
    }
}
