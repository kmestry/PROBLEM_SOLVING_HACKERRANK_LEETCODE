package com.geeksforgeeks.searching;

public class MajorityElementMoresAlgorithm {


    private int findMajorityElement(int[] arr) {

        int index = 0;
        int count = 1;

        for (int i = 1; i < arr.length; i++) {

            if (arr[i] == arr[index]) {
                count++;
            } else {
                count--;
            }

            if (count == 0) {
                //reset
                index = i;
                count = 1;
            }
        }

        return checkWhetherCandidateIsMajority(arr, arr[index]) ? arr[index] : -1;
    }

    //
    private boolean checkWhetherCandidateIsMajority(int[] arr, int candidate) {

        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == candidate) {
                count++;
            }
            if (count > arr.length / 2) {
                return true;
            }
        }

        return false;

    }
}
