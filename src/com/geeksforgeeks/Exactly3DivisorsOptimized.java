package com.geeksforgeeks;

public class Exactly3DivisorsOptimized {

    public static void main(String[] args) {

        int result = new Exactly3DivisorsOptimized().exactly3Divisors(266);
        System.out.println("result = " + result);
    }

    //number has exactly 3 divisors if
    // number is perfect square and its one multiplier is prime
    // eg 9 has 3 divisors. as 3 is prime
    // eg 25 has 3 divisors, as 5 is prime
    // eg 49 has 3 divisors , as 7 is prime
    private int exactly3Divisors(int N) {

        int count = 0;
        for (int i = 2; i <= N; i++) {
            int num = i * i;
            if (num > N) return count;

            boolean isPrime = isPrime(i);
            if (isPrime) {
                System.out.println("num = " + num);
                count++;
            }
        }

        return count;

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
