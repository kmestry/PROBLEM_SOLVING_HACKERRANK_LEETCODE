package com.leetcode;

public class ValidMountainArrayDecemberChallenge {


    public boolean validMountainArray(int[] arr) {

        int i = 1;

        int upwardSlopeCount = 0;
        int downwardSlopeCount = 0;
        boolean isPeakFound = false;

        while (i < arr.length) {
            if (!isPeakFound && arr[i] > arr[i - 1]) {
                i++;
                upwardSlopeCount++;
            } else if (!isPeakFound && arr[i] < arr[i - 1]) {
                isPeakFound = true;
            } else if (isPeakFound && arr[i] < arr[i - 1]) {
                i++;
                downwardSlopeCount++;

            } else {
                return false;
            }
        }

        return upwardSlopeCount > 0 && downwardSlopeCount > 0 && isPeakFound;

    }
}
