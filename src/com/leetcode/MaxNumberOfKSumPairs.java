package com.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MaxNumberOfKSumPairs {
//TLE in leetcode
    public static void main(String[] args) {
        int result = new MaxNumberOfKSumPairs().maxOperations(new int[]{4, 4, 1, 3, 1, 3, 2, 2, 5, 5, 1, 5, 2, 1, 2, 3, 5, 4}, 2);
        System.out.println("result = " + result);
    }

    public int maxOperations(int[] nums, int k) {
        //[1,2,3,4], k = 5
        Map<Integer, List<Integer>> indexMap = new HashMap<>();
        boolean[] visited = new boolean[nums.length];

        for (int i = 0; i < nums.length; i++) {
            List<Integer> list;
            if (indexMap.containsKey(nums[i])) {
                list = indexMap.get(nums[i]);
            } else {
                list = new ArrayList<>();
            }
            list.add(i);
            indexMap.put(nums[i], list);
        }

        System.out.println("==" + indexMap);
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int complement = k - nums[i];
            if (indexMap.containsKey(complement) && !visited[i]) {
                List<Integer> list = indexMap.get(complement);

                for (Integer integer : list) {
                    if (integer != i && !visited[integer]) {
                        visited[i] = true;
                        visited[integer] = true;
                        count++;
                        break;
                    }
                }
            }
        }

        return count;
    }
}
