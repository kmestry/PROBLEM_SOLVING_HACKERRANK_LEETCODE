package com.geeksforgeeks;

public class LCMEuclideanApproach {

    //Formula a*b = lcm(a*b) * gcd(a*b);
    public static void main(String[] args) {

        int result = new LCMEuclideanApproach().lcm(4, 6);
        System.out.println("result = " + result);
    }

    private int lcm(int a, int b) {

        return a * b / gcd(a, b);
    }

    private int gcd(int a, int b) {

        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }


}
