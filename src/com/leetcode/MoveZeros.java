package com.leetcode;

public class MoveZeros {

    public static void moveZeroes(int[] nums) {

        for (int i = nums.length - 1; i >= 0; i--) {

            if (nums[i] == 0) {
                for (int j = i; j < nums.length - 1; j++) {
                    nums[j] = nums[j + 1];
                }
                nums[nums.length - 1] = 0;
                // i = i - 1;
            }
        }
    }

    public static void moveZeroesOptimized(int[] nums) {

        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[index] = nums[i];
                index++;
            }
        }
        for (int i = index; i < nums.length; i++) {
            nums[i] = 0;
        }
    }

    //[0,1,0,3,12]
    public static void main(String[] args) {

        moveZeroesOptimized(new int[]{0, 1, 0, 3, 12});
    }
}
