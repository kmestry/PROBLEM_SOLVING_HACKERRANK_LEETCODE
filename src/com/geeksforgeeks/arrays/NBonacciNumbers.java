package com.geeksforgeeks.arrays;

import java.util.ArrayList;
import java.util.List;

public class NBonacciNumbers {
    public static void main(String[] args) {

        NBonacciNumbers nBonacciNumbers = new NBonacciNumbers();
        nBonacciNumbers.nBonacciNumbers(3, 8);
    }
    // N = 3 M = 8
    // o/p: 0 0 1 1 2 4 7 13

    private void nBonacciNumbers(int windowSize, int totalNumbers) {

        List<Integer> list = new ArrayList<>();
        for (int i = 1; i < windowSize; i++) {
            list.add(0);
        }
        list.add(1);

        int currSum = 1;

        int windowLeft = 0;
        int windowRight = windowSize - 1;

        while (list.size() < totalNumbers) {
            list.add(currSum);
            currSum = currSum - list.get(windowLeft) + list.get(windowRight + 1);
            windowLeft++;
            windowRight++;

        }

        list.forEach(integer -> System.out.print(integer + " "));


    }

}
