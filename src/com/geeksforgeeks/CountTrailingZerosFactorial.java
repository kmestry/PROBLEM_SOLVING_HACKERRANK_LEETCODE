package com.geeksforgeeks;

public class CountTrailingZerosFactorial {

    public static void main(String[] args) {

        int result = new CountTrailingZerosFactorial().countTrailingZerosOptimized(251);
        System.out.println("result = " + result);
    }

    private int countTrailingZeros(int number) {
        int factorial = 1;

        for (int i = number; i > 1; i--) {
            factorial *= i;
        }

        System.out.println("factorial = " + factorial);
        int count = 0;

        while (factorial != 0) {

            int remainder = factorial % 10;
            if (remainder == 0) {
                count++;
                factorial /= 10;
            } else {
                break;
            }

        }

        return count;
    }

    private int countTrailingZerosOptimized(int number) {
        int count = 0;
        int divisor = 5;

        while (Math.floor(number / divisor) != 0) {
            System.out.println("Math.floor(number / divisor) = " + Math.floor(number / divisor));
            count += Math.floor(number / divisor);
            divisor *= 5;
        }
        return count;

    }
}
