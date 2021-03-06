package com.geeksforgeeks;

public class PrimeFactorsEfficientApproach {

    public static void main(String[] args) {

        PrimeFactorsEfficientApproach primeFactorsEfficientApproach = new PrimeFactorsEfficientApproach();
        primeFactorsEfficientApproach.printPrimeFactorsOptimized(450);
    }

    private void printPrimeFactors(int num) {
        for (int i = 2; i * i <= num; i++) {

            while (num % i == 0) {
                System.out.println("prime factor is = " + i);
                num /= i;
            }
        }

        if (num > 1) {
            System.out.println("prime factor is =  = " + num);
        }
    }

    private void printPrimeFactorsOptimized(int number) {

        if (number <= 1) {
            return;
        }

        while (number % 2 == 0) {
            System.out.println("prime factor is = " + 2);
            number /= 2;
        }
        while (number % 3 == 0) {
            System.out.println("prime factor is =  " + 3);
            number /= 3;
        }
        for (int i = 5; i * i <= number; i += 6) {

            while (number % i == 0) {
                System.out.println("prime factor is =  " + i);
                number /= i;
            }
            while (number % (i + 2) == 0) {
                System.out.println("prime factor is  = " + i + 2);
                number /= i + 2;
            }
        }

        if (number > 3) {
            System.out.println("prime factor is = " + number);
        }

    }


}
