package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class FindAllDuplicatesInAnArray {

    public static void main(String[] args) {

        new FindAllDuplicatesInAnArray().findDuplicates(new int[]{4, 3, 2, 7, 8, 2, 3, 1});
    }

    // [4,3,2,7,8,2,3,1]
    public List<Integer> findDuplicates(int[] nums) {

        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {

            int value = nums[i];
            int absValue = Math.abs(value);
            if (nums[absValue - 1] < 0) {
                result.add(absValue);
            } else {
                nums[absValue - 1] = -1 * nums[absValue - 1];
            }
        }

        return result;

    }
}
