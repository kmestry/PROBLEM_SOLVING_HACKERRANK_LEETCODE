package com.leetcode;

import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class KthFactorOfNOptimized {


    SortedSet<Integer> set = new TreeSet<>();

    public static void main(String[] args) {
        new KthFactorOfNOptimized().kthFactor(12, 3);
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
            List<Integer> list = set.stream().limit(k).collect(Collectors.toList());
            return list.get(list.size() - 1);
        }

        return -1;

    }
}
