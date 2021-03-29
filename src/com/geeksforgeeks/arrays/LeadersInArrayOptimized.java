package com.geeksforgeeks.arrays;

import java.util.ArrayList;
import java.util.List;

public class LeadersInArrayOptimized {
    public static void main(String[] args) {

        LeadersInArrayOptimized leadersInArrayOptimized = new LeadersInArrayOptimized();
        List<Integer> list = leadersInArrayOptimized.leadersInArray(new int[]{7, 10, 4, 10, 6, 5, 2});
        System.out.println("list = " + list);
    }

    private static List<Integer> reverse(List<Integer> list) {

        int[] array = new int[list.size()];
        int index = 0;

        for (Integer i : list) {
            array[index] = i;
            index++;
        }

        int low = 0;
        int high = array.length - 1;

        while (low < high) {
            int temp = array[low];
            array[low] = array[high];
            array[high] = temp;
            low++;
            high--;
        }

        //return Arrays.stream(array).boxed().collect(Collectors.toList());

        List<Integer> reverseList = new ArrayList<>();
        for (int j : array) {
            reverseList.add(j);
        }

        return reverseList;
    }

    private ArrayList<Integer> leadersInArray(int[] arr) {

        ArrayList<Integer> list = new ArrayList<>();
        list.add(arr[arr.length - 1]);
        int currLeader = arr[arr.length - 1];
        for (int i = arr.length - 2; i >= 0; i--) {

            if (arr[i] > currLeader) {
                currLeader = arr[i];
                list.add(arr[i]);
            }
        }
        return (ArrayList<Integer>) reverse(list);

    }
}
