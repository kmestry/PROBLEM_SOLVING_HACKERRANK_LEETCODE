package com.geeksforgeeks.recursion;

import java.util.ArrayList;
import java.util.List;

public class SubSetSum {

    int count = 0;

    public static void main(String[] args) {

        SubSetSum subSetSum = new SubSetSum();

        int result = subSetSum.helper(new int[]{10, 20, 15}, 0, new ArrayList<>(), 0, 37);
        System.out.println("count = " + result);
    }

    // [ 1 , 2, 3 ]

    private int helper(int[] arr, int index, List<Integer> list, int currSum, int expectedSum) {


        if (currSum == expectedSum) {
            count++;
        }


        for (int i = index; i < arr.length; i++) {
            list.add(arr[i]);
            currSum += arr[i];
            helper(arr, i + 1, list, currSum, expectedSum);
            currSum -= list.get(list.size() - 1);
            list.remove(list.size() - 1);

        }
        return count;
    }
}
