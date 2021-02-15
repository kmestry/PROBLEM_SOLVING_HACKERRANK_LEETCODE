package com.geeksforgeeks;

public class CountDigitsMaths {
    public static void main(String[] args) {

        int ans = new CountDigitsMaths().countDigitsLogarithmic(-2);
        System.out.println("ans = " + ans);

        int ans1 = new CountDigitsMaths().countDigits(-2121212187);
        System.out.println("ans = " + ans1);

        int ans2 = new CountDigitsMaths().countDigitsApproach2(2121212187);
        System.out.println("ans = " + ans2);
    }

    private int countDigits(int number) {

        if (number == 0) {
            return 0;
        }

        return 1 + countDigits(number / 10);
    }

    private int countDigitsApproach2(int num) {
        int count = 0;

        while (num > 0) {
            num /= 10;
            count++;
        }
        return count;
    }

    //works for number greater than 0;
    private int countDigitsLogarithmic(int number) {
        if (number == 0) return 0;
        return (int) Math.floor(Math.log10(number) + 1);
    }
}
