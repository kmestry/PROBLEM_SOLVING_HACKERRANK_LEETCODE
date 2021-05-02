package com.geeksforgeeks.searching;

public class SquareRootNaiveApproach {
    public static void main(String[] args) {
        SquareRootNaiveApproach squareRootNaiveApproach = new SquareRootNaiveApproach();
        int result = squareRootNaiveApproach.floorOfSquareRoot(16);
        System.out.println("result = " + result);
    }

    private int floorOfSquareRoot(int num) {

        int i = 1;
        while (i * i <= num) {
            i++;
        }

        return i - 1;
    }
}
