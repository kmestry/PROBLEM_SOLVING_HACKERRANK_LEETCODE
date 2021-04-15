package com.geeksforgeeks.arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class FindDuplicatesInArray {

    public static ArrayList<Integer> duplicates(int[] arr, int n) {
        // code here
        Set<Integer> set = new HashSet<>();

        Set<Integer> uniqueDuplicateSet = new HashSet<>();

        for (int num : arr) {
            if (set.contains(num)) {

                uniqueDuplicateSet.add(num);
            } else {
                set.add(num);
            }
        }
        if (uniqueDuplicateSet.isEmpty()) {
            uniqueDuplicateSet.add(-1);
            return new ArrayList<>(uniqueDuplicateSet);
        } else {

            final ArrayList<Integer> list = new ArrayList<>(uniqueDuplicateSet);
            Collections.sort(list);
            return (list);
        }


    }
}
