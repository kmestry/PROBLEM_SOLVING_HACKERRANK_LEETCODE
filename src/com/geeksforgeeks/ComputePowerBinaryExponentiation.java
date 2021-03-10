package com.geeksforgeeks;

public class ComputePowerBinaryExponentiation {
    public static void main(String[] args) {

        int result = new ComputePowerBinaryExponentiation().power(4, 14);
        System.out.println("result = " + result);
    }

    //time complexity is O(logn)

    private int power(int num, int pow) {

        int result = 1;

        while (pow > 0) {
            if (pow % 2 != 0) {
                result *= num;
            }
           // pow /= 2; or pow = pow >> 1. both are same. bitwise is faster
            pow = pow >> 1;
            num *= num;
        }
        return result;
    }
}
