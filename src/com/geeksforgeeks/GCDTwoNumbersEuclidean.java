package com.geeksforgeeks;

public class GCDTwoNumbersEuclidean {

    public static void main(String[] args) {

        GCDTwoNumbersEuclidean gcdTwoNumbersEuclidean = new GCDTwoNumbersEuclidean();
        gcdTwoNumbersEuclidean.findGCD(100, 200);
    }

    private int findGCD(int num1, int num2) {

        while (num1 != num2) {
            if (num1 > num2) {
                num1 = num1 - num2;
            } else {
                num2 = num2 - num1;
            }
        }

        return num1;

    }
}
