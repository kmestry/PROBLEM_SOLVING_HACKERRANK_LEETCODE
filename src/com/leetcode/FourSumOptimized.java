package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FourSumOptimized {


    public static void main(String[] args) {
        new FourSumOptimized().fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0);
    }


    public List<List<Integer>> fourSum(int[] nums, int target) {

        Set<List<Integer>> set = new HashSet<>();

        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 3; i++) {

            for (int j = i + 1; j < nums.length - 2; j++) {

                // -2 -1 0 0 1 2
                int num1 = nums[i];
                int num2 = nums[j];


                int left = j + 1;
                int right = nums.length - 1;

                while (left < right) {
                    int sum = num1 + num2 + nums[left] + nums[right];
                    if (sum > target) {
                        right--;
                    } else if (sum < target) {
                        left++;
                    } else if (sum == target) {
                        List<Integer> list = new ArrayList<>();

                        list.add(num1);
                        list.add(num2);
                        list.add(nums[left]);
                        list.add(nums[right]);


                        set.add(list);
                        left++;
                        right--;


                    }
                }

            }
        }


        return new ArrayList<>(set);

        // -2 -1 0 0 1 2


    }
}
