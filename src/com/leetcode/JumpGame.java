package com.leetcode;

public class JumpGame {

    //[2,3,1,1,4]
    public static void main(String[] args) {

        new JumpGame().canJump(new int[]{5, 9, 3, 2, 1, 0, 2, 3, 3, 1, 0, 0});
    }

    public boolean canJump(int[] nums) {

        if (nums.length == 0)
            return false;
        if (nums.length == 1)
            return true;

        int counter = 0;

        for (int i = 0; i < nums.length; i++) {
            if (counter > nums.length + 1) return false;
            int element = nums[i];

            int checkElement = element;
            while (checkElement >= 0) {
                if (i + checkElement < nums.length - 1) break;
                if (i + checkElement > nums.length - 1) {
                    checkElement--;
                } else if (i + checkElement == nums.length - 1) {
                    return true;
                }

            }

            int index = findNextIndex(element, i, nums);
            i = index - 1;

            counter++;

        }
        return false;
    }

    private int findNextIndex(int element, int index, int[] nums) {
        for (int i = index + 1; i < nums.length && i <= (element + index); i++) {

            if (nums[i] >= element)
                return i;

        }
        return index + element;
    }
}
