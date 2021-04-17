package com.codility;

import java.util.HashSet;
import java.util.Set;

public class MinimumVacationDays {

    public static void main(String[] args) {
        MinimumVacationDays minimumVacationDays = new MinimumVacationDays();
        int result = minimumVacationDays.solution(new int[]{2, 1, 1, 3, 2, 1, 1, 3});
        System.out.println("result = " + result);
    }

    // 2, 1, 1, 3 , 2, 1 , 1 ,3
    public int solution(int[] A) {
        // write your code in Java SE 8


        Set<Integer> set = new HashSet<>();
        for (int num : A) {
            set.add(num);
        }
        Set<Integer> copySet = new HashSet<>(set);
        int minVacationDays = Integer.MAX_VALUE;
        for (int i = 0; i < A.length; i++) {
            for (int j = i; j < A.length; j++) {
                if (set.contains(A[j])) {
                    set.remove(A[j]);

                    if (set.size() == 0) {
                        minVacationDays = Math.min(minVacationDays, j - i + 1);
                        set.addAll(copySet);
                        break;
                    }
                }
            }
        }
        return minVacationDays;
    }
}
