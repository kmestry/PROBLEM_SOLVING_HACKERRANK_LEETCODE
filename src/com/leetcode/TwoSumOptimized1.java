package com.leetcode;

import java.util.Arrays;
import java.util.stream.Collectors;

public class TwoSumOptimized1 {

    public static void main(String[] args) {
        twoSum(new int[]{3, 3}, 6);
    }

    public static int[] twoSum(int[] nums, int target) {


        int[] originalArray = Arrays.copyOfRange(nums, 0, nums.length);
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            int leftPointer = i;
            int rightPointer = nums.length - 1;
            while ((leftPointer < rightPointer)) {
                if (nums[leftPointer] + nums[rightPointer] < target || (i > 0 && nums[i] == nums[i - 1])) {
                    leftPointer = leftPointer + 1;
                } else if (nums[leftPointer] + nums[rightPointer] > target) {
                    rightPointer = rightPointer - 1;
                } else {
                    int leftValue = nums[leftPointer];
                    int rightValue = nums[rightPointer];
                    if (leftValue == rightValue) {
                        int leftIndex = 0;
                        int rightIndex = 0;
                        for (int j = 0; j < originalArray.length; j++) {
                            if (originalArray[j] == leftValue) {
                                leftIndex = j;
                            }

                        }
                        for (int j = 0; j < originalArray.length; j++) {
                            if (originalArray[j] == rightValue && j != leftIndex) {
                                rightIndex = j;
                            }
                        }
                        return new int[]{leftIndex, rightIndex};
                    }

                    int leftIndex = Arrays.stream(originalArray)                    // IntStream
                            .boxed()                        // Stream<Integer>
                            .collect(Collectors.toList())   // List<Integer>
                            .indexOf(leftValue);
                    int rightIndex = Arrays.stream(originalArray)                    // IntStream
                            .boxed()                        // Stream<Integer>
                            .collect(Collectors.toList())   // List<Integer>
                            .indexOf(rightValue);
                    return new int[]{leftIndex, rightIndex};
                }


            }
        }
        return new int[]{};
    }
}
