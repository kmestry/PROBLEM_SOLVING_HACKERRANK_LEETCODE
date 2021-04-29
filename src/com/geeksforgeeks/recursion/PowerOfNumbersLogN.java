package com.geeksforgeeks.recursion;

public class PowerOfNumbersLogN {
    long mod = 1000000007;

    public static void main(String[] args) {

        PowerOfNumbersLogN powerOfNumbersLogN = new PowerOfNumbersLogN();
        long result = powerOfNumbersLogN.power(12, 21);
        System.out.println("result = " + result);
    }

    long power(int N, int R) {
        //Your code here

        return helper(N, R) % mod;

    }

    long helper(int num, int reverse) {

        if (reverse == 0) {
            return 1;
        }
        long temp = (helper(num, reverse / 2));

        if (reverse % 2 == 0) {
            return (temp % mod * temp % mod) % mod;
        } else {
            return num * (temp % mod * temp % mod) % mod;
        }

    }
}
