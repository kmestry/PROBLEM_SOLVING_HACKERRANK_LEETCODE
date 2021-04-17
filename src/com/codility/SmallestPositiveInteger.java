package com.codility;

import java.util.HashSet;
import java.util.Set;

public class SmallestPositiveInteger {

    //1, 3, 6, 4, 1, 2], the function should return 5.

    public int solution(int[] A) {
        // write your code in Java SE 8

        Set<Integer> set = new HashSet<>();

        for (int num : A) {
            set.add(num);
        }

        for (int i = 1; i <= 100000; i++) {
            if (!set.contains(i)) {
                return i;
            }
        }

        return -1;
    }
}
