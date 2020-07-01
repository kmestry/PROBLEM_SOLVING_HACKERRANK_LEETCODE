package com.hackerrank.leetcode;

import java.util.ArrayList;
import java.util.List;

public class ArrangeCoins441Optimized {

    // 1000000
    // 1000000000
    // 2147483647
    static List<Integer> listOfPerfectStairCase;

    static {
        listOfPerfectStairCase = new ArrayList<>();
        long counter = 0;
        for (int i = 1; i < Integer.MAX_VALUE; i++) {
            counter = counter + i;
            listOfPerfectStairCase.add((int) counter);
            if (counter > Integer.MAX_VALUE) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        int n = arrangeCoins(8);
        System.out.println("n = " + n);


        int m = arrangeCoins(10);
        System.out.println("m = " + m);

        int q = arrangeCoins(5);
        System.out.println("q = " + q);

    }

    public static int arrangeCoins(int n) {

        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }

        int left = 0;
        int right = listOfPerfectStairCase.size() - 1;


        int result = 0;

        while (left <= right) {
            int mid = left + ((right - left) / 2);
            int value = listOfPerfectStairCase.get(mid);
            if (n < value) {
                right = mid - 1;
            } else if (n > value) {
                left = mid + 1;
            } else {
                result = mid + 1;
                break;
            }

        }

        if (left > right) {
            result += arrangeCoins(n - 1);
        }
        return result;
    }
}
