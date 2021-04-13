package com.geeksforgeeks.arrays;

import java.util.Arrays;

public class PartitionInto3PartsWithEqualSum {


    public boolean canThreePartsEqualSum(int[] arr) {

        int totalSum = Arrays.stream(arr).sum();
        int average = totalSum / 3;

        if (totalSum % 3 != 0) {
            return false;
        }

        int partSum = 0;
        int countParts = 0;

        for (int num : arr) {
            partSum += num;
            if (partSum == average) {
                countParts++;
                partSum = 0;

                if (countParts == 3) {
                    return true;
                }
            }
        }

        return false;
    }

}
