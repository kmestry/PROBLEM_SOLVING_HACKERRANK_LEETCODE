package com.geeksforgeeks;

public class GCDTwoNumbers {


    public static void main(String[] args) {

        int gcd = GCDTwoNumbers.findGCD(7, 13);
        System.out.println("gcd = " + gcd);
    }

    //Naive solution
    private static int findGCD(int num1, int num2) {

        int smallerNum = -10;
        int gcd = -10;

        if (num1 < num2) {
            smallerNum = num1;
        } else {
            smallerNum = num2;
        }

        while (smallerNum >= 1) {
            if (num1 % smallerNum == 0 && num2 % smallerNum == 0) {
                gcd = smallerNum;
                return gcd;
            } else {
                smallerNum--;
            }
        }
        return 1;

    }
}
