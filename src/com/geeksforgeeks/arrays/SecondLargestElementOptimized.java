package com.geeksforgeeks.arrays;

public class SecondLargestElementOptimized {

    public static void main(String[] args) {

        SecondLargestElementOptimized secondLargestElementOptimized = new SecondLargestElementOptimized();
        // int res = secondLargestElementOptimized.secondLargest(new int[]{50, 50, 40, 30, 20, 10});
        int res = secondLargestElementOptimized.secondLargest(new int[]{1, 1, 1, 1, 1});
        System.out.println("res = " + res);

    }

    private int secondLargest(int[] arr) {

        int firstLargest = -100;
        int secondLargest = -100;


        for (int j : arr) {

            if (firstLargest == j) continue;
            if (j > firstLargest) {
                secondLargest = firstLargest;
                firstLargest = j;


            } else if (j > secondLargest) {
                secondLargest = j;

            }
        }
        //   System.out.println(secondLargest);

        return secondLargest == -100 ? -1 : secondLargest;
    }
}
