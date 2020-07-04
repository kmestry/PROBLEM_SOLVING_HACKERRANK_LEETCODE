package com.leetcode;

public class UglyNumberBruteForce264 {

    public static int nthUglyNumber(int n) {

        int i = 1;
        int count = 1;
        while (count < n) {
            i++;
            if (isUgly(i))
                count++;
        }
        return i;

    }

    public static boolean isUgly(int number) {

        int numberFormedByDividingBy2 = divideNumber(number, 2);
        int numberFormedByDividingBy3 = divideNumber(numberFormedByDividingBy2, 3);
        int numberFormedByDividingBy5 = divideNumber(numberFormedByDividingBy3, 5);
        return numberFormedByDividingBy5 == 1;

    }

    public static int divideNumber(int number, int divisor) {
        while (number % divisor == 0) {
            number = number / divisor;
        }
        return number;
    }

    public static void main(String[] args) {
        int result = nthUglyNumber(1690);
        //isUgly(5);
        System.out.println(result);
    }
}
