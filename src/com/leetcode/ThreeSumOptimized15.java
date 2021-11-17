package com.leetcode;

import java.util.*;
import java.util.stream.Collectors;

public class ThreeSumOptimized15 {

    public static void main(String[] args) {

        List<List<Integer>> resultList = threeSum(new int[]{-1, 0, 1, 2, -1, -4});
        System.out.println("resultList = " + resultList);
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> resultList = new HashSet<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            int fixedValue = nums[i];
            int leftPointer = i + 1;
            int rightPointer = nums.length - 1;

            if (nums.length > 3 && i == nums.length - 3)
                return resultList.stream().collect(Collectors.toList());

            if (i == 0 || fixedValue != nums[i - 1]) {
                while (leftPointer < rightPointer) {
                    if (fixedValue + nums[leftPointer] + nums[rightPointer] < 0) {
                        leftPointer = leftPointer + 1;
                    } else if (fixedValue + nums[leftPointer] + nums[rightPointer] > 0) {
                        rightPointer = rightPointer - 1;
                    } else {
                        List<Integer> innerList = new ArrayList<>();
                        innerList.add(fixedValue);
                        innerList.add(nums[leftPointer]);
                        innerList.add(nums[rightPointer]);

                        resultList.add(innerList);
                        leftPointer = leftPointer + 1;
                        rightPointer = rightPointer - 1;

                    }
                }
            }
        }

        return resultList.stream().collect(Collectors.toList());
    }
}
