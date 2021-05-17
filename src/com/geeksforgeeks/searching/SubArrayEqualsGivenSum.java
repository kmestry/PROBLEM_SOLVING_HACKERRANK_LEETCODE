package com.geeksforgeeks.searching;

import java.util.ArrayList;

public class SubArrayEqualsGivenSum {


    public static void main(String[] args) {
        SubArrayEqualsGivenSum subArrayEqualsGivenSum = new SubArrayEqualsGivenSum();
        ArrayList<Integer> list = subArrayEqualsGivenSum.subarraySum(new int[]
                        {1, 2, 3, 7, 5},
                5, 12);
        System.out.println("list = " + list);
    }

    private ArrayList<Integer> subarraySum(int[] arr, int n, int s) {
        int pointer1 = 0;
        int pointer2 = 0;

        int currSum = 0;
        ArrayList<Integer> list = new ArrayList<>();

        while (pointer1 < n && pointer2 < n) {

            if (currSum == s) {
                list.add(pointer1 + 1);
                list.add(pointer2);
                return list;
            }
            currSum += arr[pointer2];
            pointer2++;

            while (currSum > s) {
                currSum -= arr[pointer1];
                pointer1++;
            }
            if (currSum == s) {
                list.add(pointer1 + 1);
                list.add(pointer2);
                return list;
            }
        }

        list.add(-1);
        //list.add(-1);

        return list;
    }
}
