package com.hackerrank.mphas;

import java.util.List;

public class TestClass {
    public static void main(String[] args) {

    }

    private void printSecondMax(List<Integer> salaryList) {

        int maxSal = salaryList.stream().max(Integer::compareTo).get();


        int secondMax = Integer.MIN_VALUE;


        for (Integer i : salaryList) {
            if (i == maxSal) {
                continue;
            } else {
                secondMax = Math.max(i, secondMax);
            }
        }

    }
}
