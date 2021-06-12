package com.hackerrank.hackerearth_interview_test;

public class NthNumberDivisibleByTwoNumbers {

    public static void main(String[] args) {
        long answer = NthNumberDivisibleByTwoNumbers.solve(15, 20, 3);
        System.out.println(answer);
    }

    //170912549941980000
    static long solve(long a, long b, long N) {
        // Write your code here
        long lcm = (a * b) / gcdUtil(a, b);
        return lcm * N;
    }

    static long gcdUtil(long a, long b) {
        if (a == 0) {
            return b;
        }
        return gcdUtil(b % a, a);
    }
}
