package com.leetcode;

public class PoweXNOptimized50 {

    public static void main(String[] args) {
        double result = new PoweXNOptimized50().myPowIterative(2, 10);
        System.out.println("result = " + result);
    }

    private double pow_util(double x, long n) {
        if (n == 0) return 1.0;
        if (n == 1) return x;
        if (n < 0) return pow_util(1 / x, -n);
        double result = pow_util(x * x, n / 2);
        if (n % 2 == 1) result *= x;
        return result;
    }

    public double myPow(double x, int n) {
        return pow_util(x, n);
    }

    public double myPowIterative(double x, int n) {

        double ans = 1;
        long absN = Math.abs((long) n);
        while (absN > 0) {
            if ((absN & 1) == 1) ans *= x;
            absN >>= 1;
            x *= x;
        }
        return n < 0 ? 1 / ans : ans;

    }

}
