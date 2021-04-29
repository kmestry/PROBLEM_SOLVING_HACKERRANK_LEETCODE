package com.geeksforgeeks.recursion;

public class DigitalRoot {
    public static int digitalRoot(int n) {
        // add your code here

        int num = helper(n);

        while (num >= 10) {
            num = helper(num);

            if (num < 10) {
                return num;
            }
        }
        return num;

    }

    private static int helper(int num) {
        if (num == 0) {
            return 0;
        }
        return helper(num / 10) + num % 10;
    }
}
