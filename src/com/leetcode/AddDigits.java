package com.leetcode;

public class AddDigits {

    public static void main(String[] args) {
        int result = addDigits(9999);
        System.out.println("result = " + result);
    }

    //38
    public static int addDigits(int num) {

        if (num < 10) {
            return num;
        }
        return addDigits(num % 10 + num / 10);


    }

    public int addDigitsMathsRule(int num) {

        if (num == 0) return 0;
        if (num % 9 == 0) return 9;

        return num % 9;
    }
}
