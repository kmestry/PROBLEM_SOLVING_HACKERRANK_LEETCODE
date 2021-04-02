package com.geeksforgeeks.arrays;

public class MajorityElementMooresVotingAlgo {

    public static void main(String[] args) {

    }

    private int majorityElementIndex(int[] array) {

        int resultIndex = 0;
        int count = 1;

        //find the majority element index
        for (int i = 1; i < array.length; i++) {
            if (array[i] == array[resultIndex]) {
                count++;
            } else {
                count--;
            }

            if (count == 0) {
                resultIndex = i;
                count = 1;
            }
        }

        //verify if the element is actually a majoriy

        int counter = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[resultIndex] == array[i]) {
                counter++;
            }
        }

        return counter > array.length / 2 ? resultIndex : -1;
    }
}
