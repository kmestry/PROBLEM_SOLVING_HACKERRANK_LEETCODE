package com.leetcode;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {

    Set<Integer> set = new HashSet<>();

    public boolean isHappy(int n) {

        if (n == 1) return true;
        set.add(n);


        int num = n;
        int square = 0;

        while (num > 0) {

            int singleDigit = num % 10;
            square += Math.pow(singleDigit, 2);
            num /= 10;

        }

        if (set.contains(square)) return false;

        return isHappy(square);

    }
}
