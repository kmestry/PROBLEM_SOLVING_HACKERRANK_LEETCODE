package com.geeksforgeeks;

public class CheckIfPrimeFastest {
    public static void main(String[] args) {

        CheckIfPrimeFastest checkIfPrimeFastest = new CheckIfPrimeFastest();
        boolean result = checkIfPrimeFastest.isPrime(19);
        System.out.println("result = " + result);

    }

    private boolean isPrime(int num) {

        if (num == 1) return false;

        if (num == 2 || num == 3) return true;

        if (num % 2 == 0 || num % 3 == 0) return false;

        for (int i = 5; i * i <= num; i += 6) {
            if (num % i == 0 || num % (i + 2) == 0) {
                return false;
            }
        }

        return true;
    }
}
