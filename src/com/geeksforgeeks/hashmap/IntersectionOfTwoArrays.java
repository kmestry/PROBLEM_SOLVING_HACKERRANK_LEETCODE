package com.geeksforgeeks.hashmap;

import java.util.HashSet;
import java.util.Set;

public class IntersectionOfTwoArrays {
    public static int NumberofElementsInIntersection(int[] a, int[] b, int n, int m) {
        //Your code here
        Set<Integer> set = new HashSet<>();

        int maxLengthArray = Math.max(n, m);

        if (n == maxLengthArray) {
            return findCountOfCommonElements(a, b, n, m, set);
        } else {
            return findCountOfCommonElements(b, a, m, n, set);

        }
        //return 0;
    }

    private static int findCountOfCommonElements(int[] firstArray,
                                                 int[] secondArray,
                                                 int firstArrayCount,
                                                 int secondArrayCount,
                                                 Set<Integer> set) {
        int count = 0;
        for (int i = 0; i < firstArrayCount; i++) {
            set.add(firstArray[i]);
        }
        Set<Integer> seen = new HashSet<>();
        for (int i = 0; i < secondArrayCount; i++) {
            if (set.contains(secondArray[i]) && !seen.contains(secondArray[i])) {
                count++;
            }
            seen.add(secondArray[i]);
        }
        return count;
    }
}
