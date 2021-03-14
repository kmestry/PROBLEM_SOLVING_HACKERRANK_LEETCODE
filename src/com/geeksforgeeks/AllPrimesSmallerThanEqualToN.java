package com.geeksforgeeks;

public class AllPrimesSmallerThanEqualToN {


    public static void main(String[] args) {

        AllPrimesSmallerThanEqualToN allPrimesSmallerThanEqualToN = new AllPrimesSmallerThanEqualToN();
        allPrimesSmallerThanEqualToN.printAllPrimesSmallerThanEqualToN(10);
    }

    private void printAllPrimesSmallerThanEqualToN(int num) {

        for (int i = 1; i <= num; i++) {
            if (isPrime(i))
                System.out.println("prime factor is :" + i);
        }
    }

    private boolean isPrime(int number) {
        if (number == 1) return false;

        if (number == 2 || number == 3) return true;

        if (number % 2 == 0 || number % 3 == 0) return false;

        for (int i = 5; i * i <= number; i += 6) {
            if (number % i == 0 || number % (i + 2) == 0) {
                return false;
            }
        }

        return true;
    }
}
