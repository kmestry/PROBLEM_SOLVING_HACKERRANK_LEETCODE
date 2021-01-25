package com.leetcode;

public class CheckIfAllOnesAreAtLeastLengthKPlacesAway {

    public boolean kLengthApart(int[] nums, int k) {

        boolean isOneFound = false;
        int counter = 0;

        for (int n : nums) {
            if (n == 1 && !isOneFound) {
                isOneFound = true;
            } else if (isOneFound && n == 0) {
                counter++;
            } else if (isOneFound && n == 1) {
                if (counter < k) {
                    return false;
                } else {
                    counter = 0;
                }
            }
        }
        return true;
    }
}
