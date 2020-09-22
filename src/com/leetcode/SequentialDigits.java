package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class SequentialDigits {


    public static void main(String[] args) {
        new SequentialDigits().sequentialDigits(123, 123);
    }

    public List<Integer> sequentialDigits(int low, int high) {


        List<Integer> result = new ArrayList<>();

        for (int i = low; i <= high; i++) {
            boolean isSequential = isSequential(i);
            if (isSequential) {
                result.add(i);
            }

        }

        return result;
    }

    private boolean isSequential(int number) {

        int lastNum = 0;
        int count = 0;
        if (number == 123) {
            while (number > 0) {

                int remainder = number % 10;
                number /= 10;
                count++;

                System.out.println(remainder);
                if (count > 1) {
                    if (lastNum - remainder != 1) {
                        return false;
                    } else {
                        lastNum = remainder;
                        System.out.println(lastNum);
                    }
                } else
                    lastNum = remainder;


            }
        }

        return true;
    }
}
