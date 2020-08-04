package com.recursion;

public class SumOfNonNegativeNumbersUptoN {

    int result = 0;

    public static void main(String[] args) {
        int result = new SumOfNonNegativeNumbersUptoN().sumNumbers(100);
        System.out.println("result = " + result);
    }

    // 1+2+3+4+5
    public int sumNumbers(int number) {

        if (number == 0)
            return 0;

        result += number;
        sumNumbers(number - 1);

        return result;
    }
}
