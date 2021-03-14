package com.geeksforgeeks;

public class ComputingPowerEfficient {

    public static void main(String[] args) {
        long startTime = System.nanoTime();
        int result = new ComputingPowerEfficient().computingPowerRecursive(3, 7);
        long stopTime = System.nanoTime();
        System.out.println("result = " + result);
        System.out.println(stopTime - startTime);
    }

    //Formula if n is even : eg 3pow4 == 3pow2 * 3pow2
    //if n is odd : 3pow5 = 3pow4 * 3 == 3pow2 * 3pow2 * 3
    // O(logn)
    private int computingPowerRecursive(int x, int n) {

        if (n == 0)
            return 1;

        int temp = computingPowerRecursive(x, n / 2);
        temp = temp * temp;

        if (n % 2 == 0) {
            return temp;
        } else {
            return temp * x;
        }
    }

    // This is not O(logn) it is O(n/2).
    private int computingPowerIterative(int x, int n) {

        if (n % 2 == 0) {
            return computePower(x, n);
        } else {
            int newN = n - 1;
            int result = computePower(x, newN);
            return result * x;
        }
    }

    private int computePower(int x, int n) {
        int numOfTimes = n / 2;
        int result = 1;
        while (numOfTimes > 0) {
            result *= x;
            numOfTimes--;
        }

        return result * result;
    }
}
