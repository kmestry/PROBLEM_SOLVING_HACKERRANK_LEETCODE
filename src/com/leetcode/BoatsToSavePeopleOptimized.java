package com.leetcode;

import java.util.Arrays;

public class BoatsToSavePeopleOptimized {

    public int numRescueBoats(int[] people, int limit) {

        Arrays.sort(people);

        int left = 0;
        int right = people.length - 1;

        int count = 0;
        while (left <= right) {
            if (people[right] == limit) { // found heaviest person with exact weight as limit
                count++;
                right--;
            } else if (people[right] + people[left] <= limit) { // found pair of heavy + light person with weight less than limit
                count++;
                right--;
                left++;
            } else {  // heavy + light weight is > than limit so just send heavy person first in boat. greedy approach.
                count++;
                right--;
            }
        }

        return count;

    }
}
