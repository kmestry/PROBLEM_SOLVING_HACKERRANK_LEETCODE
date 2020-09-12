package com.leetcode;

public class CountPrimes {

    public int countPrimes(int n) {
        int count = 0;

        for (int i = 2; i < n; i++) {
            boolean isPrime = isPrime(i);
            if (isPrime) {

                count++;
            }
        }


        return count;

    }

    private boolean isPrime(int num) {


        if (num < 2) return false;
        if (num == 2) return true;
        if (num % 2 == 0) return false;//even number cannot be prime

        //check the odd numbers now. jump by 2 as we only need odd num check
        for (int i = 3; i <= Math.sqrt(num); i += 2) {

            if (num % i == 0) {
                return false;
            }
        }

        return true;
    }
}
