package com.geeksforgeeks.searching;

public class RoofTop {

    static int maxStep(int[] A, int N) {
        // Your code here
        int maxSteps = 0;
        int currSteps = 0;
        for (int i = 0; i < A.length - 1; i++) {
            if (A[i + 1] > A[i]) {
                currSteps++;
            } else {
                maxSteps = Math.max(maxSteps, currSteps);
                currSteps = 0;
            }
        }

        return Math.max(maxSteps, currSteps);
    }
}
