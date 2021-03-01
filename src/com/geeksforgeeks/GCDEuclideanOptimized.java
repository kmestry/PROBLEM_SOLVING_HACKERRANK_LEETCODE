package com.geeksforgeeks;

public class GCDEuclideanOptimized {
    public static void main(String[] args) {

        new GCDEuclideanOptimized().findGCD(6, 15);
    }

    private int findGCD(int a, int b) {

        if (b == 0) {
            return a;
        }

        return findGCD(b, a % b);
    }
}
