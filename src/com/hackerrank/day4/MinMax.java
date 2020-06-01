package com.hackerrank.day4;

public class MinMax {
    // Complete the miniMaxSum function below.
    //1 2 3 4 5
    //10 14
    static void miniMaxSum(int[] arr) {
        long minimum = 0;
        long maximum = 0;
        long minimumSum = 0;
        long maximumSum = 0;

        if (arr.length > 0) {
            minimum = arr[0];
            maximum = arr[0];
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < minimum)
                minimum = arr[i];
            if (arr[i] > maximum)
                maximum = arr[i];
        }
      /*  for (int i = 0; i < arr.length; i++) {
            if (arr[i] > maximum)
                maximum = arr[i];
        }*/
        if (minimum == maximum) {
            long result = minimum * (arr.length - 1);
            System.out.println(result + " " + result);
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            if (maximum != arr[i]) {
                minimumSum += arr[i];
            }
            if (minimum != arr[i]) {
                maximumSum += arr[i];
            }
        }

        System.out.println(minimumSum + " " + maximumSum);
    }

    public static void main(String[] args) {
        // miniMaxSum(new int[]{5, 5, 5, 5, 5});
        miniMaxSum(new int[]{1, 2, 3, 4, 5});
    }
}

