package com.leetcode;

public class PowerXN50 {


    public static void main(String[] args) {
        double result = new PowerXN50().calculateDouble(8.95371, -1);
        System.out.println("result = " + result);
    }

    public static double calculateDouble(double x, int n) {

        int initialN = n;
        if (n == 0) return 1;
        if (n == 1) return x;
        if (n == -1) return 1 / x;
        if (n < 0) n = n * -1;
        double initialValueOfX = x;
        double result = x;
        if (n % 2 == 0) {
            for (int i = 1; i <= n / 2 - 1; i++) {
                result = result * x;
            }
            return initialN < 0 ? (double) 1 / (result * result) : (result * result);
        } else {
            for (int i = 1; i <= n / 2 - 1; i++) {
                result = result * x;
            }
            return initialN < 0 ? (double) 1 / (result * result * initialValueOfX) : result * result * initialValueOfX;
        }
    }

    public static double myPow(double x, int n) {

        if (n == 0) return 1;
        if (n == 1) return x;
        if (n == -1) return (double) 1 / x;
        if (x == 1.0) return 1;

        if (x > 0 && n == Integer.MIN_VALUE) return 0;
        if (x < 0 && n == Integer.MIN_VALUE) return 1;
        if (x > 0 && n == Integer.MAX_VALUE) return 0;
        if (x < 0 && n == Integer.MAX_VALUE) return -1;

        if (x == 1)
            return 1;
        if (n < 0) {
            if (x < 0 && n <= Integer.MIN_VALUE)
                return 1;
            if (n <= Integer.MIN_VALUE) {
                return 0;
            }
            double result;
            n = n * -1;
            result = calculateDouble(x, n);
            return Double.valueOf(1) / result;
        }


        double result;
        result = calculateDouble(x, n);


        return n == 0 ? 1 : result;
    }
}
