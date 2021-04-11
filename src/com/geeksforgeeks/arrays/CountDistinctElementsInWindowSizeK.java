package com.geeksforgeeks.arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CountDistinctElementsInWindowSizeK {

    public static void main(String[] args) {
        CountDistinctElementsInWindowSizeK countDistinctElementsInWindowSizeK = new CountDistinctElementsInWindowSizeK();
        countDistinctElementsInWindowSizeK.countDistinct(new int[]{1, 2, 1, 3, 4, 2, 3}, 7, 4);
    }

    ArrayList<Integer> countDistinct(int[] A, int n, int k) {
        // code here
        Map<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            putInMap(A, map, i);
        }
        list.add(map.size());
        int left = 0;
        int right = k;

        while (right < n) {
            if (map.get(A[left]) <= 1) {
                map.remove(A[left]);
            } else {
                map.put(A[left], map.get(A[left]) - 1);
            }
            putInMap(A, map, right);
            list.add(map.size());
            right++;
            left++;
        }
        System.out.println(list);
        return list;
    }

    private void putInMap(int[] A, Map<Integer, Integer> map, int i) {
        if (map.containsKey(A[i])) {
            map.put(A[i], map.get(A[i]) + 1);
        } else {
            map.put(A[i], 1);
        }
    }
}
