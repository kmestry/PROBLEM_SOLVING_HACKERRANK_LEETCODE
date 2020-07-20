package com.leetcode;

public class RemoveDuplicatesFromSortedArray {

    // [0,0,1,1,1,2,2,3,3,4],

    public static void main(String[] args) {
        removeDuplicates(new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4});
        // removeDuplicates(new int[]{1,1,2});
    }

    public static int removeDuplicates(int[] nums) {

        int arrayLength = nums.length;
        for (int i = 0; i < arrayLength - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                for (int j = i; j < arrayLength - 1; j++) {
                    nums[j] = nums[j + 1];
                }
                i = i - 1;
                arrayLength--;

            }
        }

        return arrayLength;
    }

}
