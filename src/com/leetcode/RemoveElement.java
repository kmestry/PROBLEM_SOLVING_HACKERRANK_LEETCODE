package com.leetcode;

public class RemoveElement {
    public static void main(String[] args) {

        removeElement(new int[]{1, 2, 2, 3, 4, 2}, 2);
    }

    public static int removeElement(int[] nums, int val) {

        int lengthCounter = nums.length;
        int arrayLength = nums.length;
        for (int i = 0; i < arrayLength; i++) {
            if (nums[i] == val) {
                for (int j = i; j < nums.length - 1; j++) {
                    nums[j] = nums[j + 1];
                }
                lengthCounter--;
                arrayLength--;
                i = i - 1;
            }
        }
        return lengthCounter;
    }
}
