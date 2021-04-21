package com.geeksforgeeks.recursion;

public class FindOutput3 {

    static int fun(int n) {
        if (n == 1)
            return 0;
        else {
            int val = fun(n / 2);
            System.out.println("1 + val = " + (1 + val));
            return 1 + val;
        }
    }

    public static void main(String[] args) {
        System.out.println(fun(16));
    }

}
