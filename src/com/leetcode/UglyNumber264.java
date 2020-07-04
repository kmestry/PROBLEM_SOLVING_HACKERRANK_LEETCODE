package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class UglyNumber264 {

    public static void main(String[] args) {
        int result = nthUglyNumber(374);
        System.out.println(result);
    }

    public static boolean isUgly(int number) {
        if (number == 1)
            return true;
        //finding prime factors of a number.
        List<Integer> primeFactorList = new ArrayList<>();

        while (number % 2 == 0) {
            primeFactorList.add(2);
            number = number / 2;
        }

        for (int i = 3; i <= (int) Math.sqrt(number); i = i + 2) {

            while (number % i == 0) {
                primeFactorList.add(i);
                number = number / i;

            }
            if (i > 5) {
                break;
            }
        }
        if (number > 2) {
            primeFactorList.add(number);
        }
        int count = (int) primeFactorList.stream().filter(integer -> integer > 5).count();

        return count <= 0;

    }

    public static int nthUglyNumber(int n) {
        List<Integer> uglyNumberList = new ArrayList<>();
        //2123366400
        //1000000000
        for (long i = 1; i < Integer.MAX_VALUE; i++) {
            if (isUgly((int) i)) {
                uglyNumberList.add((int) i);
            }
            if (uglyNumberList.size() == n) {
                return uglyNumberList.get(n - 1);
            }
        }

        return 0;
    }

}
