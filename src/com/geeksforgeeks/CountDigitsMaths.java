package com.geeksforgeeks;

public class CountDigitsMaths {
    public static void main(String[] args) {

        int ans = new CountDigitsMaths().countDigitsLogarithmic(-2);
        System.out.println("ans = " + ans);

        int ans1 = new CountDigitsMaths().countDigits(-2121212187);
        System.out.println("ans = " + ans1);
    }

    private int countDigits(int number) {

        if (number == 0) {
            return 0;
        }

        return 1 + countDigits(number / 10);
    }

    //works for number greater than 0;
    private int countDigitsLogarithmic(int number) {
        if (number == 0) return 0;
        return (int) Math.floor(Math.log10(number) + 1);
    }
}
