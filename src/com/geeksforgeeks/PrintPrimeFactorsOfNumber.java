package com.geeksforgeeks;

public class PrintPrimeFactorsOfNumber {

    public static void main(String[] args) {

        PrintPrimeFactorsOfNumber printPrimeFactorsOfNumber = new PrintPrimeFactorsOfNumber();
        printPrimeFactorsOfNumber.printPrimeFactors(13);
    }

    private void printPrimeFactors(int num) {

        for (int i = 2; i <= num; i++) {
            if (isPrime(i)) {
                int x = i;

                while (num % x == 0) {
                    System.out.println("prime factor = " + i);
                    x = x * i;
                }
            }
        }
    }

    private boolean isPrime(int num) {

        if (num == 1) return false;

        if (num == 2 || num == 3) return true;

        if (num % 2 == 0 || num % 3 == 0) {
            return false;
        }

        for (int i = 5; i * i <= num; i += 6) {
            if (num % i == 0 || num % (i + 2) == 0) {
                return false;
            }
        }
        return true;
    }
}

