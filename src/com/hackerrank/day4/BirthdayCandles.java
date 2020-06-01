package com.hackerrank.day4;

public class BirthdayCandles {

    // Complete the birthdayCakeCandles function below.
    //4
    //3 2 1 3
    static int birthdayCakeCandles(int[] ar) {
        int tallestCandleCounter = 0;
        long tallestCandle = 0;

        for (int i = 0; i < ar.length; i++) {
            if (ar[i] > tallestCandle) {
                tallestCandle = ar[i];
            }
        }

        for (int i = 0; i < ar.length; i++) {
            if (ar[i] == tallestCandle)
                tallestCandleCounter++;
        }

        System.out.println(tallestCandleCounter);
        return tallestCandleCounter;
    }


    public static void main(String[] args) {
        birthdayCakeCandles(new int[]{44, 53, 31, 27, 77, 60, 66, 77, 26, 36});

    }
}

