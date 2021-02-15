package com.recursion;

public class TimeComplexityAnalysis {

    public static void main(String[] args) {

        int val = new TimeComplexityAnalysis().f(10);
        System.out.println(val);
    }

    public int f(int x) {
        if (x < 1) return 1;
        else return f(x - 1) + g(x);
    }

    private int g(int x) {
        if (x < 2) return 2;
        else return f(x - 1) + g(x / 2);
    }
}
