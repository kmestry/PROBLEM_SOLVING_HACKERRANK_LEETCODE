package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class FindAllDuplicates {

    public static void main(String[] args) {

        List<Integer> result = new FindAllDuplicates().findDuplicates(new int[]{4, 3, 2, 7, 8, 2, 3, 1});
        System.out.println("result = " + result);
    }

    //[4,3,2,7,8,2,3,1]
    public List<Integer> findDuplicates(int[] nums) {

        List<Integer> result = new ArrayList<>();

        for (int number : nums) {
            int absoluteNumber = Math.abs(number);
            if (nums[absoluteNumber - 1] < 0) {
                result.add(absoluteNumber);
            }

            nums[absoluteNumber - 1] = -1 * nums[absoluteNumber - 1];
        }

        return result;

    }
}
