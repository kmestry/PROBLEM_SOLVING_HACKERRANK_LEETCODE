package com.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class KthFactorOfNOptimizedList {


    Set<Integer> set = new HashSet<>();

    public static void main(String[] args) {
        int res = new KthFactorOfNOptimizedList().kthFactor(12, 3);
        System.out.println("res = " + res);
    }

    public int kthFactor(int n, int k) {

        final double sqrt = Math.sqrt(n);
        for (int i = 1; i <= sqrt; i++) {

            if (n % i == 0) {
                set.add(i);
                set.add(n / i);
            }
        }

        if (set.size() >= k) {
            return new ArrayList<>(set).get(k - 1);
        }

        return -1;

    }
}
