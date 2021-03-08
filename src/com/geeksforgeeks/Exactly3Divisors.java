package com.geeksforgeeks;

import java.util.HashSet;
import java.util.Set;

public class Exactly3Divisors {

    //naive solution

    public static void main(String[] args) {
        Exactly3Divisors exactly3Divisors = new Exactly3Divisors();
        int result = exactly3Divisors.exactly3Divisors(6);
        System.out.println("result = " + result);
    }

    public int exactly3Divisors(int N) {
        //Your code here
        int count = 0;
        for (int i = 1; i <= N; i++) {
            if (has3Divisors(i)) {
                count++;
            }
        }

        return count;

    }

    private boolean has3Divisors(int num) {
        Set<Integer> set = new HashSet();
        int i;
        for (i = 1; i * i < num; i++) {
            if (num % i == 0) {
                set.add(i);
                if (set.size() > 3) {
                    return false;
                }
            }
        }

        for (int j = i; j >= 1; j--) {
            if (num % j == 0) {
                set.add(num / j);
                if (set.size() > 3) {
                    return false;
                }
            }
        }

        return set.size() == 3;

    }
}
