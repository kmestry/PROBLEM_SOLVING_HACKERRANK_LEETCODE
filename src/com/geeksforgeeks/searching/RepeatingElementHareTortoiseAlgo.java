package com.geeksforgeeks.searching;

public class RepeatingElementHareTortoiseAlgo {


    // 1 3 2 4 6 5 7 3

    private int repeatingElement(int[] arr) {

        int slow = arr[0];
        int fast = arr[0];

        do {
            slow = arr[slow]; // 3
            fast = arr[arr[fast]]; // 4
        } while (slow != fast);
        //slow == fast
        slow = arr[0];

        while (slow != fast) {
            slow = arr[slow];
            fast = arr[fast];
        }

        return arr[slow];

    }
}
