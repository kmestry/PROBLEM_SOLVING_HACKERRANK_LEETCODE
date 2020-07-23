package com.leetcode;

public class RemoveDuplicatesFromSortedArrayOptimized {

    public static void main(String[] args) {
        removeDuplicates(new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4});
    }

    public static int removeDuplicates(int[] nums) {

        int counter = 0;
        int leftPointer = 0;
        int rightPointer = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[rightPointer] == nums[rightPointer + 1]) {
                rightPointer++;
            } else {
                nums[leftPointer + 1] = nums[rightPointer + 1];
                leftPointer++;
                rightPointer++;
                counter++;
            }
        }

        /*for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }*/
        return counter + 1;
    }
}
