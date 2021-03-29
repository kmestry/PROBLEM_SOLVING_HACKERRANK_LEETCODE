package com.geeksforgeeks.arrays;

import java.util.ArrayList;
import java.util.List;

public class LeadersInArray {

    public static void main(String[] args) {

        LeadersInArray leadersInArray = new LeadersInArray();
        List<Integer> list = leadersInArray.leadersInArray(new int[]{7, 10, 4, 3, 6, 5, 2});
        System.out.println("list = " + list);
    }

    private List<Integer> leadersInArray(int[] arr) {

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {

            boolean isLeader = true;
            for (int j = i + 1; j < arr.length; j++) {

                if (arr[i] <= arr[j]) {
                    isLeader = false;
                    break;
                }
            }
            if (isLeader) {
                list.add(arr[i]);
            }
        }
        return list;
    }
}
