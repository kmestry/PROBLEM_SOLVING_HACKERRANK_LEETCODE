package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class FindKthPositive {

    public static void main(String[] args) {
        new FindKthPositive().findKthPositive(new int[]{1, 2, 3, 4}, 2);
    }

    public int findKthPositive(int[] arr, int k) {
        //[2,3,4,7,11], k = 5

        List<Integer> list = new ArrayList<>();

        int counter = 1;
        int pointerArray = 0;

        while (list.size() != k) {
            if (pointerArray >= arr.length) {
                list.add(counter);
                counter++;
            } else if (counter != arr[pointerArray]) {
                list.add(counter);
                counter++;
            } else {
                counter++;
                pointerArray++;
            }
        }

        return list.get(list.size() - 1);

    }
}
