package com.hackerrank.leetcode;


import java.util.Random;

public class GuessNumber {
    public int guessNumber(int n) {

        int left = 1;
        int right = n;
        int guessNumResult = 0;
        while (left <= right) {
            int mid = left + ((right - left) / 2);
            guessNumResult = guess(mid);
            if (guessNumResult == -1) {
                right = mid - 1;
            } else if (guessNumResult == 1) {
                left = mid + 1;
            } else {
                return mid;
            }

        }
        return -1;
    }

    private int guess(int mid) {
        //randomly returns 1,0,-1;
        return new Random().nextInt();
    }
}

