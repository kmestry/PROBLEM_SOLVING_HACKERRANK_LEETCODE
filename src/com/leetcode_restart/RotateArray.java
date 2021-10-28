package com.leetcode_restart;

public class RotateArray {

    public void rotate(int[] nums, int k) {
        if (nums.length <= 1) return;
        k = k % nums.length;
        int[] aux = new int[k];

        int index = aux.length - 1;
        int numsIndex = nums.length - 1;

        while (index >= 0) {
            aux[index] = nums[numsIndex];
            index--;
            numsIndex--;
        }

        int i = nums.length - 1 - k;
        int s = nums.length - 1;
        while (i >= 0) {
            nums[s] = nums[i];
            i--;
            s--;
        }

        int k_1 = 0;
        while (k_1 < aux.length) {
            nums[k_1] = aux[k_1];
            k_1++;
        }
    }
}
