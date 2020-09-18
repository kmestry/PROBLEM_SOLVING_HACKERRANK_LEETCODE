package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FourSumBinarySearch {

    Set<List<Integer>> resultList = new HashSet<>();

    public static void main(String[] args) {
        List<List<Integer>> list = new FourSumBinarySearch().fourSum(new int[]{-1, 0, -5, -2, -2, -4, 0, 1, -2}, -9);
        System.out.println("list = " + list);
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {

            for (int j = i + 1; j < nums.length; j++) {

                for (int k = j + 1; k < nums.length; k++) {


                    int threeSum = nums[i] + nums[j] + nums[k];
                    int findElement = target - (threeSum);
                    int searchResult = binarySearch(nums, findElement, k + 1);

                    if (searchResult != Integer.MAX_VALUE) {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[k]);
                        list.add(searchResult);
                        resultList.add(list);

                    }

                }

            }
        }

        return new ArrayList<>(resultList);

    }

    private int binarySearch(int[] nums, int target, int index) {

        int left = index;
        int right = nums.length - 1;


        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return nums[mid];
            } else if (target > nums[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }

        }

        return Integer.MAX_VALUE; //not found.

    }
}
