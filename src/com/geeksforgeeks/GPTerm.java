package com.geeksforgeeks;

public class GPTerm {

    public static void main(String[] args) {
        GPTerm gpTerm = new GPTerm();
        double result = gpTerm.termOfGP(84, 87, 3);
        System.out.println("result = " + result);
    }

    public double termOfGP(int A, int B, int N) {
        //Your code here
        if (N == 1) return A;
        if (N == 2) return B;
        double ratio = (double) B / (double) A;
        //System.out.println(ratio);

        double val = Math.pow(ratio, N - 1);


        return A * val;

    }
}
