package com.datastructure_2_studyplan_leetcode.day2;

public class SortColors {

    public void sortColors(int[] nums) {

        int[] arr = new int[3]; //store count of 0, 1 and 2
        for (int num : nums) {
            arr[num]++;
        }

        int value = 0;
        int index = 0;
        for (int count : arr) {
            populateArray(nums, count, index, value);
            value++;
            index += count;
        }

    }

    private void populateArray(int[] nums, int count, int index, int value) {

        for (int i = index; i < index + count; i++) {
            nums[i] = value;
        }
    }
}
