package com.leetcode;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TwoSumDifferentApproach1 {

    public static void main(String[] args) {
        int[] result = twoSum(new int[]{-3, 4, 3, 90}, 0);
    }

    public static int[] twoSum(int[] nums, int target) {
        List<Integer> listToCheckForTarget = Arrays.stream(nums).boxed().collect(Collectors.toList());


        listToCheckForTarget.sort(Integer::compareTo);

        for (int i = 0; i < listToCheckForTarget.size(); i++) {
            int fixedValue = listToCheckForTarget.get(i);
            //find complement of target.
            int valueToFind = target - fixedValue;

            if (fixedValue == valueToFind) {
                int leftIndex = 0;
                int rightIndex = 0;
                for (int j = 0; j < nums.length; j++) {
                    if (nums[j] == fixedValue) {
                        leftIndex = j;
                    }

                }
                for (int j = 0; j < nums.length; j++) {
                    if (nums[j] == valueToFind && j != leftIndex) {
                        rightIndex = j;
                    }
                }
                return new int[]{leftIndex, rightIndex};
            }

            int result = Arrays.binarySearch(listToCheckForTarget.toArray(), valueToFind);
            if (result >= 0) {
                int rightValue = listToCheckForTarget.get(result);
                int leftIndex = Arrays.stream(nums)                    // IntStream
                        .boxed()                        // Stream<Integer>
                        .collect(Collectors.toList())   // List<Integer>
                        .indexOf(fixedValue);
                int rightIndex = Arrays.stream(nums)                    // IntStream
                        .boxed()                        // Stream<Integer>
                        .collect(Collectors.toList())   // List<Integer>
                        .indexOf(rightValue);
                return new int[]{leftIndex, rightIndex};

            }


        }

        return new int[]{};
    }
}
