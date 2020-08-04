package com.recursion;

public class Factorial {

    int result = 1;

    public static void main(String[] args) {
        int result = new Factorial().findFactorial(7);
        System.out.println("result = " + result);
    }

    public int findFactorial(int number) {

        System.out.println("number =inininininin " + number);
        if (number <= 1)
            return 1;

        result *= number;
        number = number - 1;
        findFactorial(number);
        System.out.println("donenennene" + number);
        return result;
    }
}
