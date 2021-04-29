package com.geeksforgeeks.recursion;

public class PowerOfNumbers {

    long mod = 1000000007;

    public static void main(String[] args) {
        PowerOfNumbers powerOfNumbers = new PowerOfNumbers();
        long result = powerOfNumbers.power(12, 21);
        System.out.println("result = " + result);
    }

    long power(int N, int R) {
        //Your code here

        return helper(N, R) % mod;


    }

    //DIVIDE AND CONQUER ALGORITHM : O(N)
    long helper(int num, int reverse) {


        if (reverse == 0) {
            return 1;
        } else if (reverse % 2 == 0) {
            return (helper(num, reverse / 2) % mod *
                    helper(num, reverse / 2) % mod) % mod;
        } else {
            return num * (helper(num, reverse / 2) % mod *
                    helper(num, reverse / 2) % mod) % mod;
        }


    }
}
