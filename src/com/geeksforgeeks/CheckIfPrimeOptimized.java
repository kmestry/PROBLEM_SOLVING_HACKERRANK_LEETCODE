package com.geeksforgeeks;

public class CheckIfPrimeOptimized {

    public static void main(String[] args) {

        CheckIfPrimeOptimized checkIfPrimeOptimized = new CheckIfPrimeOptimized();
        boolean result = checkIfPrimeOptimized.checkPrime(45);
        System.out.println("result = " + result);
    }

    private boolean checkPrime(int number) {

        if (number == 1) return false;
        for (int i = 2; i * i <= number; i++) {
            if (number % i == 0) {
                return false;
            }
        }

        return true;
    }
}
