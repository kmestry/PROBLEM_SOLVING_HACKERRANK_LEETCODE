package com.geeksforgeeks;

public class CheckIfPrime {

    public static void main(String[] args) {
        CheckIfPrime checkIfPrime = new CheckIfPrime();
        boolean result = checkIfPrime.isPrime(1);
        System.out.println("result = " + result);
    }


    private boolean isPrime(int number) {

        if (number == 1) return false; // 1 is neither prime nor composite
        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                return false;
            }
        }

        return true;

    }
}
