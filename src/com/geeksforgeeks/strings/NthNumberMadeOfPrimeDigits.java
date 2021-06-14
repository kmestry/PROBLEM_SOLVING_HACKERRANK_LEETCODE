package com.geeksforgeeks.strings;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NthNumberMadeOfPrimeDigits {

    public static int primeDigits(int n) {
        //Your code here
        List<Integer> list = Arrays.asList(2, 3, 5, 7);
        if (n != 0 && n < 5) {
            return list.get(n - 1);
        }
        Set<Integer> set = new HashSet<>();
        set.add(2);
        set.add(3);
        set.add(5);
        set.add(7);
        int currentNum = 4;
        for (int i = 22; i < Integer.MAX_VALUE; i++) {

            int number = i;

            boolean isVisited = false;
            while (number != 0) {
                int digit = number % 10;
                if (!set.contains(digit)) {
                    isVisited = true;
                    break;
                } else {
                    number = number / 10;
                }

            }
            if (isVisited) {
                continue;
            } else {
                currentNum++;

            }

            if (currentNum == n) {
                return i;
            }
        }
        return -1;

    }
}
