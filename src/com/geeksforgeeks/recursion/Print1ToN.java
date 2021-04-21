package com.geeksforgeeks.recursion;

public class Print1ToN {

    public static void main(String[] args) {

        Print1ToN print1ToN = new Print1ToN();
        print1ToN.print1TON(5);
    }

    private void print1TON(int N) {

        if (N == 0) return;
        print1TON(N - 1);
        System.out.println("N = " + N);
    }
}
