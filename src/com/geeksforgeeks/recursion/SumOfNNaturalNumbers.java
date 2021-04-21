package com.geeksforgeeks.recursion;

public class SumOfNNaturalNumbers {
    public static void main(String[] args) {

        SumOfNNaturalNumbers sumOfNNaturalNumbers = new SumOfNNaturalNumbers();
        int result = sumOfNNaturalNumbers.sum(2);
        System.out.println("result = " + result);

    }

    private int sum(int N) {
        if (N == 1) {
            return 1;
        }

        return N + sum(N - 1);

    }
}
