package com.geeksforgeeks.arrays;

public class FrequenciesInSortedArray {

    public static void main(String[] args) {

        FrequenciesInSortedArray frequenciesInSortedArray = new FrequenciesInSortedArray();
        frequenciesInSortedArray.printFrequency(new int[]{40, 50, 50, 50});
    }

    private void printFrequency(int[] arr) {

        int currElement = arr[0];
        int frequency = 0;

        for (int j : arr) {
            if (j == currElement) {
                frequency++;
            } else {
                System.out.println("frequency of  " + currElement + " is = " + frequency);
                currElement = j;
                frequency = 1;
            }
        }
        System.out.println("frequency of  " + currElement + " is = " + frequency);
    }
}
