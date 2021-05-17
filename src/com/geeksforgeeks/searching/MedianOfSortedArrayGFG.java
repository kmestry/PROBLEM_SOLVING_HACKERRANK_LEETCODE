package com.geeksforgeeks.searching;

public class MedianOfSortedArrayGFG {

    public static int findMedian(int[] arr, int n, int[] brr, int m) {
        //Your code here

        int pointer1 = 0;
        int pointer2 = 0;
        int[] auxArr = new int[n + m];
        int index = 0;
        while (pointer1 < n && pointer2 < m && index < auxArr.length) {

            int element1 = arr[pointer1];
            int element2 = brr[pointer2];

            if (element1 < element2) {
                auxArr[index] = element1;
                index++;
                pointer1++;
            } else {
                auxArr[index] = element2;
                index++;
                pointer2++;
            }
        }
        while (pointer1 < n && index < auxArr.length) {
            auxArr[index] = arr[pointer1];
            index++;
            pointer1++;
        }

        while (pointer2 < m && index < auxArr.length) {
            auxArr[index] = brr[pointer2];
            index++;
            pointer2++;
        }

        if (auxArr.length % 2 == 0) {
            int mid = auxArr.length / 2;
            int sum = auxArr[mid] + auxArr[mid - 1];
            return (int) Math.floor(sum / 2.0);
        } else {
            return auxArr[auxArr.length / 2];
        }
    }
}
