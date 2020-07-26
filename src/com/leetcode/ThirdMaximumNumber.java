package com.leetcode;

import java.util.Comparator;
import java.util.SortedSet;
import java.util.TreeSet;

public class ThirdMaximumNumber {

    //2, 2, 3, 1
    public static void main(String[] args) {
        int result = thirdMax(new int[]{-2147483648, 1, 1});
        System.out.println("result = " + result);
    }

    public static int thirdMax(int[] nums) {
        // (o1, o2) ->  (o2 - o1)
        SortedSet<Long> sortedSet = new TreeSet<>(Comparator.comparingLong(Long::longValue).reversed());

        System.out.println("Integer.MIN_VALUE = " + Integer.MIN_VALUE);
        for (int i = 0; i < nums.length; i++) {

            sortedSet.add((long) nums[i]);
        }


        int counter = 1;
        Long thirdMaxElement = Long.valueOf(0);
        if (sortedSet.size() >= 3) {
            for (Long number : sortedSet) {
                if (counter == 3) {
                    thirdMaxElement = number;
                    break;
                }
                counter++;
            }
        }
        return Math.toIntExact(sortedSet.size() >= 3 ? thirdMaxElement : sortedSet.first());
    }
}
